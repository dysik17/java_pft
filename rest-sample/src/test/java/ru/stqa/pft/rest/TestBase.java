package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {

  private Executor getExecutor() {
    return Executor.newInstance().auth("b31e382ca8445202e66b03aaf31508a3", "");
  }

  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/issues.json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json")
                    .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                            new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  //функция, которая через Remote API должна получать из баг-трекера информацию о баг-репорте с заданным идентификатором,
  //и возвращать значение false или true в зависимости от того, помечен он как исправленный или нет
  public Issue isIssueOpen(int id) throws IOException {
    String json = getExecutor().execute(Request.Get(String.format("https://bugify.stqa.ru/api/issues/%.json", id)))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
    return new Gson().fromJson(issues, Issue.class);
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    Issue waitingIssue = isIssueOpen(issueId);
    if (!waitingIssue.getStateName().equals("Closed")) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}

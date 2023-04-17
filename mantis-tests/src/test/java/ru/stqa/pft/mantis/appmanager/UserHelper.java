package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.User;

public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public String changePasswordByUser(String url, User user) {
    wd.get(url);
    String selectedUser = wd.findElement(By.cssSelector("[class='form-control']")).getText();
    type(By.name("realname"), user.getUserName());
    type(By.name("password"), user.getNewUserPassword());
    type(By.name("password_confirm"), user.getNewUserPassword());
    click(By.cssSelector("span[class='submit-button'] button"));
    return selectedUser;
  }
}
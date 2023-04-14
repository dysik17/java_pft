package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithabTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("dysik17", "java_pft")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationContact {
  private FirefoxDriver wd;

  public NavigationContact(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToHome() {
    wd.findElement(By.linkText("home")).click();
  }
}

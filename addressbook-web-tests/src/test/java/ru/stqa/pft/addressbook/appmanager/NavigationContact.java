package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationContact extends HelperBase{
  public NavigationContact(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHome() {
    click(By.linkText("home"));
  }
}

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationContact extends HelperBase{
  public NavigationContact(WebDriver wd) {
    super(wd);
  }

  public void returnToHome() {
    click(By.linkText("home"));
  }
}

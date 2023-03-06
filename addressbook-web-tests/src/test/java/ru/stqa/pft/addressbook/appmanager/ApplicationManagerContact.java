package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerContact {
  FirefoxDriver wd;
  private SessionHelperContact sessionHelperContact;
  private NavigationContact navigationContact;
  private ContactHelper contactHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    contactHelper = new ContactHelper(wd);
    navigationContact = new NavigationContact(wd);
    sessionHelperContact = new SessionHelperContact(wd);
    sessionHelperContact.login("admin", "secret");
  }

  public void logOutOfTheSystem() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationContact getNavigationContact() {
    return navigationContact;
  }
}

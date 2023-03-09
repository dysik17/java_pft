package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerContact {
  WebDriver wd;
  private SessionHelperContact sessionHelperContact;
  private NavigationContact navigationContact;
  private ContactHelper contactHelper;
  private String browser;


  public ApplicationManagerContact(String browser) {
    this.browser = browser;
  }
  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

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

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private final String browser;

  //Group
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  //Contact
  private SessionHelperContact sessionHelperContact;
  private NavigationContact navigationContact;
  private ContactHelper contactHelper;


  public ApplicationManager(String browser) {
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

    //Group
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void initContact(){
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    //Contact
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
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

  //GroupHelper
  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  //ContactHelper
  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  //NavigationHelperGroup
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  //NavigationHelperContact
  public NavigationContact getNavigationContact() {
    return navigationContact;
  }
}

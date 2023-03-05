package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManagerContact;

public class TestBaseContact {

  protected final ApplicationManagerContact appContact = new ApplicationManagerContact();

  @BeforeMethod
  public void setUp() throws Exception {
    appContact.init();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    appContact.stop();
  }
}

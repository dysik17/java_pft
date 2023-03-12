package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoNewCreationContactPage();
    app.getContactHelper().createContact(new ContactData("Elena", "Morozova", "Moscow", "458963", "85899562365", "ElenaM@mail.ru", "Test1"));
    app.logOutOfTheSystem();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}

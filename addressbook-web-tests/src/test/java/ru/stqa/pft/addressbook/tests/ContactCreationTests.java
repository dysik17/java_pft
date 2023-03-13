package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoNewCreationContactPage();
    app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Moscow", "159951", "89159107458", "PetrP@mail.ru", "Test1"));
    app.logOutOfTheSystem();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    appContact.getContactHelper().gotoNewCreationContactPage();
    appContact.getContactHelper().fillContactForm(new ContactData("Slava", "Rakov", "Moscow", "154236", "82569853621", "00123@mail.ru"));
    appContact.getContactHelper().submitContactCreation();
    appContact.getContactHelper().returnToContactPage();
    appContact.logOutOfTheSystem();
  }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    appContact.getContactHelper().gotoNewCreationContactPage();
    appContact.getContactHelper().fillContactForm(new ContactData("Maria", "Lapovka", "SPb", null, "85554449889", null));
    appContact.getContactHelper().submitContactCreation();
    appContact.getContactHelper().returnToContactPage();
    appContact.logOutOfTheSystem();
  }
}

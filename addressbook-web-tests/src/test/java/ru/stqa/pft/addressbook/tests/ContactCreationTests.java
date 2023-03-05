package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    appContact.getContactHelper().gotoNewCreationContactPage();
    appContact.getContactHelper().fillContactForm(new ContactData("Grisha", "Pibov", "SPb", "458963", "89589654763", "Yalta123@mail.ru"));
    appContact.getContactHelper().submitContactCreation();
    appContact.getContactHelper().returnToContactPage();
    appContact.logOutOfTheSystem();
  }
}

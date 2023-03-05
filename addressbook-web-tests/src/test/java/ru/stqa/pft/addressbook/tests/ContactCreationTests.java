package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    appContact.gotoNewCreationContactPage();
    appContact.fillContactForm(new ContactData("Liza", "Popova", "Yalta", "851554", "899565854563", "Yalta@mail.ru"));
    appContact.submitContactCreation();
    appContact.returnToContactPage();
    appContact.logOutOfTheSystem();
  }
}

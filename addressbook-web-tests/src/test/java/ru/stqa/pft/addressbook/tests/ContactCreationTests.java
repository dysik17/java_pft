package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().gotoNewCreationContactPage();
    app.getContactHelper().createContact(new ContactData("Marina", "Fadeeva", "Kostroma", "56321", "89879567896", "MarinaF@mail.ru", "Testik1"));
    app.logOutOfTheSystem();
  }
}

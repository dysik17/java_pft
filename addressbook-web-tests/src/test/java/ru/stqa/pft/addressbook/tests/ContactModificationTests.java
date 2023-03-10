package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    app.getContactHelper().selectContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Kasolapova", "Kostroma", "56321", "89879567896", "MarinaF@gmail.com", "Testik1"), false);
    app.getContactHelper().updateContactModification();
    app.getContactHelper().returnToContactPage();
  }
}


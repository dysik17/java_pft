package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    appContact.getContactHelper().selectContactModification();
    appContact.getContactHelper().fillContactForm(new ContactData("Daria", "Lapovka", "SPb", "998877", "85554449889", "1236987453@gmail.com"));
    appContact.getContactHelper().updateContactModification();
    appContact.getContactHelper().returnToContactPage();
  }
}

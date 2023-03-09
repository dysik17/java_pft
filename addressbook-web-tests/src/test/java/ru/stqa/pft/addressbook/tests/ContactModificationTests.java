package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    appContact.getContactHelper().selectContactModification();
    appContact.getContactHelper().fillContactForm(new ContactData("Karina", "Kasolapova", "Moscow", "456985", "89657458936", "dkmvsd@gmail.com"));
    appContact.getContactHelper().updateContactModification();
    appContact.getContactHelper().returnToContactPage();
  }
}

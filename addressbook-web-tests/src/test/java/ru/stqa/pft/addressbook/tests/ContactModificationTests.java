package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    app.getContactHelper().selectContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Kasolapova", "Moscow", "456985", "89657458936", "dkmvsd@gmail.com", "Test3"), false);
    app.getContactHelper().updateContactModification();
    app.getContactHelper().returnToContactPage();
  }
}


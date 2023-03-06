package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    appContact.getContactHelper().selectContactModification();
    appContact.getContactHelper().fillContactForm(new ContactData("Ivan", "Rakov", "Yalta", "154236", "82569853621", "00123@mail.ru"));
    appContact.getContactHelper().updateContactModification();
    appContact.getContactHelper().returnToContactPage();
  }
}

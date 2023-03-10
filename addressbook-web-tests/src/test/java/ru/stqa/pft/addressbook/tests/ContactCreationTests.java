package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().gotoNewCreationContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Kirill", "Ptashkin", "Moscow", "654321", "89879568596", "Kirill@mail.ru", "Test3"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    app.logOutOfTheSystem();
  }
}

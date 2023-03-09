package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().gotoNewCreationContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Sergey", "Sepgeev", "Kostroma", "123654", "85554449889", null));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    app.logOutOfTheSystem();
  }
}

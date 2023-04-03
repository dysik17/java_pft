package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

public class AddingContactGroupTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Groups groups = app.db().groups();
    ContactData newContact = new ContactData().withFirstName("Marina").withLastName("Tverdova").withAddress("Moscow").withTelephoneHome("485962").withTelephoneMobile("891590302").withEmail("MarinaT@mail.ru")
            .inGroup(groups.iterator().next());
    app.contact().creationPage();
    app.contact().fillContactForm2(newContact, true);
    app.contact().submitContactCreation();
    app.contact().returnToContactPage();
    verifyContactListInUI();
  }
}

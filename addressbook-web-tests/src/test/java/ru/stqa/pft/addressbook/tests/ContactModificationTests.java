package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBaseContact{
  @Test
  public void testContactModification(){
    app.getContactHelper().gotoNewCreationContactPage();
    int after = app.getGroupHelper().getGroupCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Fadeeva", "Kostroma", "56321", "89879567896", "MarinaF@mail.ru", "Testik1"));
    }
    app.getContactHelper().selectContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Kasolapova", "Kostroma", "56321", "89879567896", "MarinaF@gmail.com", "Testik1"));
    app.getContactHelper().updateContactModification();
    app.getContactHelper().returnToContactPage();
    int before = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}


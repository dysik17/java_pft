package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends  TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().gotoNewCreationContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Fadeeva", "Kostroma", "56321", "89879567896", "MarinaF@mail.ru", "Testik1"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContactModification(before - 1);
    app.getContactHelper().DeleteContact();
    app.getNavigationHelper().returnToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
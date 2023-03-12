package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends  TestBaseContact {

  @Test
  public void testContactDeletion() throws Exception {
    int before = app.getGroupHelper().getGroupCount();
    app.getContactHelper().gotoNewCreationContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Fadeeva", "Kostroma", "56321", "89879567896", "MarinaF@mail.ru", "Testik1"));
    }
    app.getContactHelper().DeleteContact();
    app.getNavigationContact().returnToHome();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
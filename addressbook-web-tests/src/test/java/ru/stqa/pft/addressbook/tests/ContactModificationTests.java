package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification() {
    app.getContactHelper().gotoNewCreationContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Fadeeva", null, null, null, null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Nina", "Veselova", "Moscow", "4569852", "89879563620", "NinaV@gmail.com");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().updateContactModification();
    app.getNavigationHelper().returnToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}


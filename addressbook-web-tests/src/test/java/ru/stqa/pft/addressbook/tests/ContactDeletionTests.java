package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends  TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().creationPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Marina").withLastName("Fadeeva").withAddress("Kostroma").withTelephoneHome("56321").withTelephoneMobile("89879567896").withEmail("MarinaF@mail.ru"));
    }
  }
  @Test
  public void testContactDeletion() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    app.contact().delete(deleteContact);
    app.goTo().returnToHome();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteContact);
    Assert.assertEquals(before, after);
  }
}
package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends  TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().returnToHome();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Slava").withFirstName("Viktorov"));
    }
  }
  @Test
  public void testContactDeletion() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().returnToHome();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
      Assert.assertEquals(before, after);
  }
}
package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends  TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().creationPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Marina", "Fadeeva", "Kostroma", "56321", "89879567896", "MarinaF@mail.ru"));
    }
  }
  @Test
  public void testContactDeletion() throws Exception {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().returnToHome();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
      Assert.assertEquals(before, after);
  }
}
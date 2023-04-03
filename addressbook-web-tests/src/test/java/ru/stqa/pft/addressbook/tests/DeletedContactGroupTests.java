package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

public class DeletedContactGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().returnToHome();
      app.contact().create(new ContactData().withFirstName("Slava").withFirstName("Viktorov"));
    }
  }

  @Test
  public void testDeleteGroups() {
    app.goTo().groupPage();
    Groups groups = app.db().groups();
    app.goTo().returnToHome();
    Contacts contacts = app.contact().all();
    verifyContactListInUI();
  }
}

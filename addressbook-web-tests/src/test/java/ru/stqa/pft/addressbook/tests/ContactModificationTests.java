package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().returnToHome();
      app.contact().create(new ContactData().withFirstName("Slava").withFirstName("Viktorov"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Kirill").withLastName("Veselov").withAddress("Moscow").withTelephoneHome("453116").withTelephoneMobile("89879569594").withEmail("RitaH@gmail.com");
    app.goTo().returnToHome();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}


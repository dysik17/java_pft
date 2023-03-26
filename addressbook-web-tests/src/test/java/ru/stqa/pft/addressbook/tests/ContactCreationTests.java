package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.contact().creationPage();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withFirstName("Irina").withLastName("Popova").withAddress("Moscow").withTelephoneHome("478965").withTelephoneMobile("891590304").withEmail("IrinaP@mail.ru").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadContactCreation() throws Exception {
    Contacts before = (Contacts) app.contact().all();
    app.contact().creationPage();
    ContactData contact = new ContactData().withFirstName("Marina'").withLastName("Tverdova").withAddress("Moscow").withTelephoneHome("485962").withTelephoneMobile("891590302").withEmail("MarinaT@mail.ru");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = (Contacts) app.contact().all();
    assertThat(after, equalTo(before));
  }
}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.contact().creationPage();
    ContactData contact = new ContactData().withFirstName("Marina").withLastName("Orlova").withAddress("Moscow").withTelephoneHome("145985").withTelephoneMobile("8915917865").withEmail("MarinaO@mail.ru");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}

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
    ContactData contact = new ContactData().withFirstName("Maksim").withLastName("Lipov").withAddress("Moscow").withTelephoneHome("202020").withTelephoneMobile("8915912020").withEmail("MaksimL@mail.ru");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}

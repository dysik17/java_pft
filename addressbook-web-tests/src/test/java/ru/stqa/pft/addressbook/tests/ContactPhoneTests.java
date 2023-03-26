package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    assertThat(contact.getAllsPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTelephoneHome(), contact.getTelephoneMobile())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
  private String mergeEmail(ContactData contact) {
    return Arrays.asList(contact.getEmail())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }
}

package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    gotoNewCreationContactPage();
    fillContactForm(new ContactData("Ira", "Ipatova", "Perm", "45468", "897815", "1@mail.ru"));
    submitContactCreation();
    returnToContactPage();
    logOutOfTheSystem();
  }
}
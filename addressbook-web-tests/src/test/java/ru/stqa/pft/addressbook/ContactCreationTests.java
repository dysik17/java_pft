package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends testBaseContact {

  @Test
  public void testContactCreation() throws Exception {
    gotoNewCreationContactPage();
    fillContactForm(new ContactData("Ivan", "Ivanov", "Moscow", "654321", "89103749595", "321@mail.ru"));
    submitContactCreation();
    returnToContactPage();
    logOutOfTheSystem();
  }
}
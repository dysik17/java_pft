package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends  TestBaseContact {

  @Test
  public void testContactDeletion() throws Exception {
    appContact.getContactHelper().DeleteContact();
    appContact.getNavigationContact().returnToHome();
  }
}
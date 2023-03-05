package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends  TestBaseContact {

  @Test
  public void testContactDeletion() throws Exception {
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
    wd.findElement(By.linkText("home")).click();
    wd.findElement(By.linkText("Logout")).click();
  }
}

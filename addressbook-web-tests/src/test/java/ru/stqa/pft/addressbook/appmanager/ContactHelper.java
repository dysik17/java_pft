package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends ContactBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.firstName());
    type(By.name("lastname"), contactData.lastName());
    type(By.name("address"), contactData.address());
    type(By.name("home"), contactData.telephoneHome());
    type(By.name("mobile"), contactData.telephoneMobile());
    type(By.name("email"), contactData.email());
  }

  public void gotoNewCreationContactPage() {
    click(By.linkText("add new"));
  }

  public void DeleteContact() {
    click(By.xpath("//img[@alt='Edit']"));
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void selectContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
}

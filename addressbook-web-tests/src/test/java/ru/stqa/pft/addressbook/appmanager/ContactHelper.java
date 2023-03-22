package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("mobile"), contactData.getTelephoneMobile());
    type(By.name("email"), contactData.getEmail());
  }

  public void creationPage() {
    click(By.linkText("add new"));
  }

  public void deleteContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }
  public void editContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

  public void updateContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void create(ContactData contact) {
    fillContactForm(contact);
    submitContactCreation();
    returnToContactPage();
  }
  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact);
    updateContactModification();
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    wd.switchTo().alert().accept();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.linkText("home page"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastname = (element.findElement(By.xpath(".//td[2]")).getText());
      String firstname = (element.findElement(By.xpath(".//td[3]")).getText());
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return contacts;
  }
}

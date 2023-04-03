package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("mobile"), contactData.getTelephoneMobile());
    type(By.name("email"), contactData.getEmail());

  }

  public void fillContactForm2(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("mobile"), contactData.getTelephoneMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }
  }

  //выбор группы
  public void groupSelection(int id) {
    wd.findElement(By.cssSelector(String.format("select[name='group']option[value='%s']",id))).click();
  }

  //выбор пользователя
  public void contactSelection(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
  }

  //нажатие кнопки удалить из группы
  public void removeFromGroup() {
    click(By.name("remove"));
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
    fillContactForm(contact, true);
    submitContactCreation();
    returnToContactPage();
    contactCashe = null;
  }
  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, true);
    updateContactModification();
    returnToContactPage();
    contactCashe = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
    contactCashe = null;
  }

  public void deletingGroupFromContact(ContactData contactData, boolean deletion) {
    groupSelection(contactData.getId()); //выбор группы
    contactSelection(contactData.getId()); //выбор пользователя
    removeFromGroup();

    if (deletion) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.linkText("home page"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCashe = null;

  public Contacts all() {
    if (contactCashe != null) {
      return new Contacts(contactCashe);
    }

    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = (element.findElement(By.xpath(".//td[3]")).getText());
      String lastname = (element.findElement(By.xpath(".//td[2]")).getText());
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCashe.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return new Contacts(contactCashe);
  }

  public Set<ContactData> alls() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id =Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String adress = cells.get(3).getText();
      String email = cells.get(4).getText();
      String allsPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAddress(adress).withEmail(email)
              .withAllsPhones(allsPhones));
    }
    return contacts;
  }
  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withAddress(address).withTelephoneHome(home).withTelephoneMobile(mobile).withEmail(email);
  }
}

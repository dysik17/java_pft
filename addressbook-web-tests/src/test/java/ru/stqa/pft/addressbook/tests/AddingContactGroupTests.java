package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddingContactGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstName("Elena").withLastName("Nikolaeva")
              .withAddress("Moscow").withTelephoneMobile("8914759620")
              .withEmail("123@mail.ru"));
      app.goTo().homePage();
    }
  }
  @Test
  public void testContactCreation() throws Exception {
    ContactData contact = app.db().contacts().iterator().next();
    Groups beforeAdd = contact.getGroups(); //контакты в группах до добавления

    Groups groups = app.db().groups(); //группы в БД
    GroupData group = groups.iterator().next();

    //контакт не состоит в группе вообще или не стоит в группе, в которую хотим добавить
    if (contact.getGroups().size() == 0 || !contact.getGroups().contains(group)) {
      app.goTo().homePage();
      app.contact().addToGroup(contact, group);
      beforeAdd.add(group);
    } else {
      //если контакт состоит в группе, в которую хотим добавить
      //есть свободная группа, чтобы добавить
      if (contact.getGroups().size() < groups.size()) {
        for (GroupData g : groups) {
          if (!contact.getGroups().contains(g)) {
            app.contact().addToGroup(contact, g);
            beforeAdd.add(group);
            break;
          }
        }
        //нет свободной группы
      } else {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        GroupData newGroup = new GroupData().withName("Группа" + formatDate.format(date))
                .withFooter("footer").withHeader("header");
        beforeAdd.add(newGroup);
      }
    }

    Groups afterAdd = app.db().contacts().iterator().next().getGroups();
    assertThat(afterAdd.size(), equalTo(beforeAdd.size()));
    assertThat(afterAdd, equalTo(beforeAdd.withAdded(group)));
  }

  private void createGroup(GroupData group) {
    app.goTo().groupPage();
    app.group().create(group);
    app.goTo().homePage();
    System.out.println("Создана новая группа с именем " + group.getName());
  }
}

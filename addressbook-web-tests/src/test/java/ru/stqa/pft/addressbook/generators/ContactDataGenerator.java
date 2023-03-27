package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  //сохранение данных в файл
  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s; %s; %s; %s; %s; %s\n", contact.getLastName(), contact.getFirstName(), contact.getAddress(), contact.getEmail(), contact.getTelephoneHome(), contact.getTelephoneMobile()));
    }
    writer.close();
  }

  //генерация данных
  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withLastName(String.format("lastname %s", i))
              .withFirstName(String.format("firstname %s",i))
              .withAddress(String.format("address %s", i))
              .withEmail(String.format("email %s", i))
              .withTelephoneHome(String.format("telephoneHome %s", i))
              .withTelephoneMobile(String.format("telephoneMobile %s", i)));
    }
    return contacts;
  }
}

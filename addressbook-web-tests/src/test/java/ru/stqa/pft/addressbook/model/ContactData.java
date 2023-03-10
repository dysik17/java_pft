package ru.stqa.pft.addressbook.model;

public class ContactData {

  private final String firstName;
  private final String lastName;
  private final String address;
  private final String telephoneHome;
  private final String telephoneMobile;
  private final String email;
  private String group;

  public ContactData(String firstName, String lastName, String address, String telephoneHome,
                     String telephoneMobile, String email, String group) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.telephoneHome = telephoneHome;
    this.telephoneMobile = telephoneMobile;
    this.email = email;
    this.group = group;
  }

  public String getGroup() {
    return group;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephoneHome() {
    return telephoneHome;
  }

  public String getTelephoneMobile() {
    return telephoneMobile;
  }

  public String getEmail() {
    return email;
  }
}


package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private final String id;
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String telephoneHome;
  private final String telephoneMobile;
  private final String email;

  public ContactData(String firstName, String lastName, String address, String telephoneHome,
                     String telephoneMobile, String email) {
    this.id = null;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.telephoneHome = telephoneHome;
    this.telephoneMobile = telephoneMobile;
    this.email = email;
  }

  public ContactData(String id, String firstName, String lastName, String address, String telephoneHome,
                     String telephoneMobile, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.telephoneHome = telephoneHome;
    this.telephoneMobile = telephoneMobile;
    this.email = email;
  }

  public String getId() {
    return id;
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


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (!Objects.equals(id, that.id)) return false;
    if (!Objects.equals(firstName, that.firstName)) return false;
    return Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}


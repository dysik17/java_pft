package ru.stqa.pft.addressbook;

public record ContactData(String firstName, String lastName, String address, String telephoneHome,
                          String telephoneMobile, String email) {
}
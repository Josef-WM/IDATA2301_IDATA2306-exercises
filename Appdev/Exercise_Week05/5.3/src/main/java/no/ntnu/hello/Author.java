package no.ntnu.hello;

public class Author {
  private int id;
  private String firstName;
  private String lastName;
  private int birthYear;

  public Author(int id, String firstName, String lastName, int birthYear) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
  }

  public int getId() {
    return id;
  }

  void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getBirthYear() {
    return birthYear;
  }

  void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }
}
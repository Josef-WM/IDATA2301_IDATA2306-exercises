package no.ntnu.hello;

public class Book {
  private int id;
  private String title;
  private int year;
  private int numberOfPages;

  public Book(int id, String title, int year, int numberOfPages) {
    this.id = id;
    this.title = title;
    this.year = year;
    this.numberOfPages = numberOfPages;
  }

  public int getId() {
    return id;
  }

  void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  void setYear(int year) {
    this.year = year;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }
}
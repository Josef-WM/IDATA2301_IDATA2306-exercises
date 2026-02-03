package no.ntnu.hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class BookController {
  private final HashMap<Integer, Book> bookCollection;

    public BookController() {
      bookCollection = new HashMap<>();
      initializeData();
    }

    public void addBook(Book book) {
      bookCollection.put(book.getId(), book);
    }

    public Book getBook(int id) {
      return bookCollection.get(id);
    }

    public void removeBook(int id) {
      bookCollection.remove(id);
    }

    public void initializeData() {
      addBook(new Book(1, "One Hundred Years of Solitude", 1967, 417));
      addBook(new Book(2, "The Great Gatsby", 1925, 180));
      addBook(new Book(3, "Pride and Prejudice", 1813, 432));
      addBook(new Book(4, "The Lord of the Rings", 1955, 417));
      addBook(new Book(5, "To Kill a Mockingbird", 1960, 281));
      addBook(new Book(6, "1984", 1949, 328));
      addBook(new Book(7, "Moby Dick", 1851, 635));
      addBook(new Book(8, "War and Peace", 1869, 122));
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
      return new ArrayList<>(bookCollection.values());
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
      Book book = getBook(id);
      if (book == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      return book;
    }
}


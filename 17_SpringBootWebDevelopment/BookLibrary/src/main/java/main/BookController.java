package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.model.Book;
import main.model.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    // Рекомендуемый вариант внедрения зависимости:
    // внедрение зависимости в класс через конструктор
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/")
    public List<Book> list() {
        Iterable<Book> bookIterable = bookRepository.findAll();

        List<Book> books = new ArrayList<>();
        for (Book book : bookIterable) {
            books.add(book);
        }
        return books;
    }

    @PostMapping("/books/")
    public int add(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }
}
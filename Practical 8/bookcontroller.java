package com.example.bookapi;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class bookcontroller {

    private List<Book> books = new ArrayList<>();

    public bookcontroller() {

        books.add(new Book(
                1,
                "Java Programming",
                "James Gosling",
                "English"
        ));

        books.add(new Book(
                2,
                "Spring Boot",
                "Rod Johnson",
                "English"
        ));

        books.add(new Book(
                3,
                "Python Basics",
                "Guido van Rossum",
                "English"
        ));
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {

        books.add(book);

        return "Book info which has been added";
    }

    @PutMapping("/books/{id}")
    public String updateBook(
            @PathVariable int id,
            @RequestBody Book updatedBook) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setName(updatedBook.getName());
                book.setAuthor(updatedBook.getAuthor());
                book.setLang(updatedBook.getLang());

                return "Book info which has been updated";
            }
        }

        return "Book not found";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {

        for (Book book : books) {

            if (book.getId() == id) {

                books.remove(book);

                return "Book record deleted successfully";
            }
        }

        return "Book not found";
    }
}

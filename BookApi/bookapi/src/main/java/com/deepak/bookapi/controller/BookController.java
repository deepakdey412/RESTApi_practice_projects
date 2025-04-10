package com.deepak.bookapi.controller;

import com.deepak.bookapi.model.Book;
import com.deepak.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // ✅ Get all books
    @GetMapping("/getAllBook")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // ✅ Get book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElse(null);
    }

    // ✅ Add new book
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // ✅ Update book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // ✅ Delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return "Book deleted successfully.";
        } else {
            return "Book not found.";
        }
    }
}

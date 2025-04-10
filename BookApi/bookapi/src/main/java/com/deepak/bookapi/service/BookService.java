package com.deepak.bookapi.service;

import com.deepak.bookapi.model.Book;
import com.deepak.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 1. Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 2. Get single book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // 3. Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // 4. Update a book
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    // 5. Delete a book
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

package com.ecommerce.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by its ID
    public Optional<Book> getBookById(int id) {
        return Optional.ofNullable(bookRepository.findById(id));
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book - not to do for Master Thesis
    //    public Book updateBook(int bookId, Book updatedBook) {
    //        if (bookRepository.existsById(bookId)) {
    //            updatedBook.setId(bookId);
    //            return bookRepository.save(updatedBook);
    //        } else {
    //            throw new RuntimeException("Book not found with id: " + bookId);
    //        }
    //    }
    //
    //    // Delete a book by its ID
    //    public void deleteBook(int bookId) {
    //        if (bookRepository.existsById(bookId)) {
    //            bookRepository.deleteById(bookId);
    //        } else {
    //            throw new RuntimeException("Book not found with id: " + bookId);
    //        }
    //    }
}
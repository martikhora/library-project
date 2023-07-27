package com.application.library.service;

import com.application.library.entity.Book;
import com.application.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List <Book> findAllBooks() { //getting all books
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {//getting a specific book from repository
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No such book found"));
        return book;
    }

    public void createBook(Book book) { //adding a new book
        bookRepository.save(book);
    }

    public void deleteBook (Long id) { //removing book
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No such book found"));
        bookRepository.deleteById(book.getId());
    }

    public void updateBook(Book book) { //updating book
        bookRepository.save(book);
    }
}

package com.application.library.service;

import com.application.library.entity.Book;
import com.application.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List <Book> findAllBooks() { //getting all books
        return bookRepository.findAll();  //todo pageable query
    }

    public Book findBookById(Long id) {//getting a specific book from repository
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No such book found")); //todo to business exception or empty book
        return book;
    }

    public Book createBook(Book book) { //adding a new book
        return bookRepository.save(book);
    }

    public void deleteBook (Long id) { //removing book
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No such book found"));
        bookRepository.deleteById(book.getId());
    }

    public void updateBook(Book book) { //updating book
        bookRepository.save(book);
    }
}

package com.application.library.controller;

import com.application.library.dto.BookDto;
import com.application.library.entity.Book;
import com.application.library.mapper.BookMapper;
import com.application.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping("/books") //todo pageable request
    public List<BookDto> findAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return bookMapper.convertToBookDto(books);
    }

    @GetMapping("/book/{id}")
    public BookDto findBook(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return bookMapper.convertToBookDto(book);
    }

    @GetMapping("/remove-book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/save-book")
    public BookDto saveBook(BookDto bookDto) {
        Book book = bookMapper.convertToBook(bookDto);
        Book savedBook = bookService.createBook(book);
        return bookMapper.convertToBookDto(savedBook);
    }

//    @GetMapping("/update-book/{id}")
//    public String updateBook(@PathVariable Long id) {
//        Book book = bookService.findBookById(id);
//        return "update-book";
//    }
//
//    @PostMapping("/save-update/{id}")
//    public String updateBook(@PathVariable Long id, Book book) {
//        if (result.hasErrors()) {
//            return "update-book";
//        }
//        bookService.updateBook(book);
//        return "redirect:/books";
//    }
}

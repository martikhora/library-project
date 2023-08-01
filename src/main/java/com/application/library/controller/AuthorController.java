package com.application.library.controller;

import com.application.library.dto.AuthorDto;
import com.application.library.entity.Author;
import com.application.library.mapper.AuthorMapper;
import com.application.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping("/authors")
    public List<AuthorDto> findAllAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        return authorMapper.convertToAuthorDto(authors);
    }

    @GetMapping("/author/{id}")
    public AuthorDto findAuthor(@PathVariable Long id) {
        Author author = authorService.findAuthorById(id);
        return authorMapper.convertToAuthorDto(author);
    }

    @GetMapping("/remove-author/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @PostMapping("/save-author")
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author author = authorMapper.convertToAuthor(authorDto);
        Author savedAuthor = authorService.createAuthor(author);
        return authorMapper.convertToAuthorDto(savedAuthor);
    }

//    @GetMapping("/update-author/{id}")
//    public String updateAuthor(@PathVariable Long id, Model model) {
//        Author author = authorService.findAuthorById(id);
//        model.addAttribute("author", author);
//        return "update-author";
//    }
//
//    @PostMapping("/save-update-author/{id}")
//    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model) {
//        if (result.hasErrors()){
//            return "update-author";
//        }
//        authorService.updateAuthor(author);
//        model.addAttribute("authors", authorService.findAllAuthors());
//        return "redirect:/authors";
//    }
}

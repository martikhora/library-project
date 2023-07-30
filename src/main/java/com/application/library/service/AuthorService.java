package com.application.library.service;

import com.application.library.entity.Author;
import com.application.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() { //getting all authors
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {//getting a specific author from repository
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("No such author found"));
    }

    public Author createAuthor(Author author) { //adding a new author
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) { //removing author
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("No such author found"));
        authorRepository.deleteById(author.getId());
    }

    public void updateAuthor(Author author) { //updating author
        authorRepository.save(author);
    }
}

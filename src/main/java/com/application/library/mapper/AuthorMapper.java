package com.application.library.mapper;

import com.application.library.dto.AuthorDto;
import com.application.library.dto.BookDto;
import com.application.library.entity.Author;
import com.application.library.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = BaseConfig.class)
public interface AuthorMapper {

    AuthorDto convertToAuthorDto(Author Author); //this one converts an entity to dto
    List<AuthorDto> convertToAuthorDto(List<Author> authors);
    Author convertToAuthor(AuthorDto authorDto); //this one converts a dto to entity
}

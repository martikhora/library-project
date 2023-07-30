package com.application.library.mapper;

import com.application.library.dto.BookDto;
import com.application.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = BaseConfig.class)
public interface BookMapper {

    BookDto convertToBookDto(Book book);//this one converts an entity to dto

    List<BookDto> convertToBookDto(List<Book> book);

    Book convertToBook(BookDto bookDto); //this one converts a dto to entity
}

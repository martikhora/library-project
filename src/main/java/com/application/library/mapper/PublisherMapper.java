package com.application.library.mapper;

import com.application.library.dto.CategoryDto;
import com.application.library.dto.PublisherDto;
import com.application.library.entity.Category;
import com.application.library.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = BaseConfig.class)
public interface PublisherMapper {

    PublisherDto convertToPublisherDto(Publisher publisher); //this one converts an entity to dto
    List<PublisherDto> convertToPublisherDto(List<Publisher> publishers);
    Publisher convertToPublisher(PublisherDto publisherDto); //this one converts a dto to entity
}

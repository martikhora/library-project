package com.application.library.mapper;

import com.application.library.dto.CategoryDto;
import com.application.library.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = BaseConfig.class)
public interface CategoryMapper {

    CategoryDto convertToCategoryDto(Category category); //this one converts an entity to dto
    List<CategoryDto> convertToCategoryDto(List<Category> categories);
    Category convertToCategory(CategoryDto categoryDto); //This one converts a dto to entity
}

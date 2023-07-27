package com.application.library.service;

import com.application.library.entity.Category;
import com.application.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() { //getting all categories
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {//getting a specific category from repository
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No such category found"));
    }

    public void createCategory(Category category) { //adding a new category
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) { //removing category
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No such category found"));
        categoryRepository.deleteById(category.getId());
    }

    public void updateCategory(Category category) { //updating category
        categoryRepository.save(category);
    }
}

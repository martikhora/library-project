package com.application.library.controller;

import com.application.library.dto.CategoryDto;
import com.application.library.entity.Category;
import com.application.library.mapper.CategoryMapper;
import com.application.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        return categoryMapper.convertToCategoryDto(categories);
    }

    @GetMapping("/category/{id}")
    public CategoryDto findCategory(@PathVariable Long id) {
        Category category = categoryService.findCategoryById(id);
        return categoryMapper.convertToCategoryDto(category);
    }

    @GetMapping("/remove-category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @PostMapping("/save-category")
    public CategoryDto saveCategory(CategoryDto categoryDto){
        Category category = categoryMapper.convertToCategory(categoryDto);
        Category savedCategory = categoryService.createCategory(category);
        return categoryMapper.convertToCategoryDto(savedCategory);
    }

//    @GetMapping("/update-category/{id}")
//    public String updateCategory(@PathVariable Long id, Model model) {
//        Category category = categoryService.findCategoryById(id);
//        model.addAttribute("category", category);
//        return "update-category";
//    }
//
//    @PostMapping("/update-category/{id}")
//    public String saveCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
//        if (result.hasErrors()){
//            return "update-category";
//        }
//        categoryService.createCategory(category);
//        model.addAttribute("categories", categoryService.findAllCategories());
//        return "redirect:/categories";
//    }
}



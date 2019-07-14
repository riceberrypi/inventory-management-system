package com.project.inventory.service;

import com.project.inventory.dto.CategoryDto;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(String id);
    CategoryDto getCategoryByName(String name);
    void deleteCategory(String id);
}

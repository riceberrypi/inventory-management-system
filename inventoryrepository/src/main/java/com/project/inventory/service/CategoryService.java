package com.project.inventory.service;

import com.project.inventory.dto.CategoryDto;
import com.project.inventory.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(String id);
    CategoryDto getCategoryByName(String name);
    void deleteCategory(String id);
    List<CategoryEntity> findAll();
}

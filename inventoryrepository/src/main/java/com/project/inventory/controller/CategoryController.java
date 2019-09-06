package com.project.inventory.controller;

import com.project.inventory.dto.CategoryDto;
import com.project.inventory.model.response.CategoryResponse;
import com.project.inventory.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String id){
        CategoryDto categoryDto = categoryService.getCategoryById(id);

        CategoryResponse categoryResponse = modelMapper.map(categoryDto,CategoryResponse.class);

        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<CategoryResponse> getCategoryByName(@PathVariable String name){
        CategoryDto categoryDto = categoryService.getCategoryByName(name);

        CategoryResponse categoryResponse = modelMapper.map(categoryDto,CategoryResponse.class);

        return ResponseEntity.ok(categoryResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryDto categoryRequestModel){
        CategoryDto categoryDto = modelMapper.map(categoryRequestModel,CategoryDto.class);

        CategoryDto createdUser = categoryService.createCategory(categoryDto);

        CategoryResponse categoryResponse = modelMapper.map(createdUser,CategoryResponse.class);

        return ResponseEntity.ok(categoryResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryDto categoryRequestModel){
        CategoryDto categoryDto = modelMapper.map(categoryRequestModel,CategoryDto.class);

        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto);

         CategoryResponse categoryResponse = modelMapper.map(updatedCategory,CategoryResponse.class);

         return ResponseEntity.ok(categoryResponse);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);

        return id;
    }
}

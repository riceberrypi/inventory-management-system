package com.project.inventory.service;

import com.project.inventory.dto.ProductDto;

public interface ProductService {

    ProductDto getProductById(String id);
    ProductDto getProductByName(String name);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProduct(String id);
}

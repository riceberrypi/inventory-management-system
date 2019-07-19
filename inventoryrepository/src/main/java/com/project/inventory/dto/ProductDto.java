package com.project.inventory.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;
    private String productName;
    private String productLabel;
    private SupplierDto supplierDto;
    private CategoryDto categoryDto;

    public ProductDto(){

    }

    public ProductDto(String productId, String productName, String productLabel, SupplierDto supplierDto, CategoryDto categoryDto) {
        this.productId = productId;
        this.productName = productName;
        this.productLabel = productLabel;
        this.supplierDto = supplierDto;
        this.categoryDto = categoryDto;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public SupplierDto getSupplierDto() {
        return supplierDto;
    }

    public void setSupplierDto(SupplierDto supplierDto) {
        this.supplierDto = supplierDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}

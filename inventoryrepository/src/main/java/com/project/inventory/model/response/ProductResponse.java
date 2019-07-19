package com.project.inventory.model.response;

import com.project.inventory.dto.CategoryDto;
import com.project.inventory.dto.SupplierDto;

import java.util.List;

public class ProductResponse {

    private String productId;
    private String productName;
    private String productLabel;
    private List<SupplierDto> supplierDto;
    private List<CategoryDto> categoryDto;

    public List<SupplierDto> getSupplierDto() {
        return supplierDto;
    }

    public void setSupplierDto(List<SupplierDto> supplierDto) {
        this.supplierDto = supplierDto;
    }

    public List<CategoryDto> getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(List<CategoryDto> categoryDto) {
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
}

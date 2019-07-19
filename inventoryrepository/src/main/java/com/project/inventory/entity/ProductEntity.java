package com.project.inventory.entity;

import com.project.inventory.dto.ProductDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tbl_products")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductEntity() {
    }

    public ProductEntity(ProductDto productDto) {
        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.productLabel = productDto.getProductLabel();
    }

    @Id
    @Column(name="product_id",length = 50)
    private String productId;

    @Column(name="product_name",length = 50)
    private String productName;

    @Column(name="product_label",length = 50)
    private String productLabel;

    @ManyToOne
    @JoinColumn(name="tbl_category_category_id")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name="tbl_supplier_supplier_id")
    private SupplierEntity supplierEntity;

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
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

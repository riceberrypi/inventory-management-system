package com.project.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tbl_products")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="product_id",length = 50)
    private String productId;

    @Column(name="product_name",length = 50)
    private String productName;

    @Column(name="product_label",length = 50)
    private String productLabel;

    @ManyToOne
    @JoinColumn(name="tbl_category_category_id")
    private List<CategoryEntity> categoryEntity;

    @ManyToOne
    @JoinColumn(name="tbl_supplier_supplier_id")
    private List<SupplierEntity> supplierEntity;

    public List<CategoryEntity> getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(List<CategoryEntity> categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<SupplierEntity> getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(List<SupplierEntity> supplierEntity) {
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

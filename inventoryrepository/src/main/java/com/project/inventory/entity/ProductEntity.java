package com.project.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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

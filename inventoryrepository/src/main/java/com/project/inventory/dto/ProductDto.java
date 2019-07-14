package com.project.inventory.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productId;
    private String productName;
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

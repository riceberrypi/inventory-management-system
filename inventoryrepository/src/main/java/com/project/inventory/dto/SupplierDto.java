package com.project.inventory.dto;

import java.io.Serializable;

public class SupplierDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String supplierId;
    private String supplierName;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}

package com.project.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="tbl_suppliers")
public class SupplierEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="supplier_id",length = 50)
    private String supplierId;

    @Column(name="supplier_name",length = 50)
    private String supplierName;

    @OneToMany(mappedBy = "supplierEntity",cascade = CascadeType.ALL)
    private ProductEntity productEntity;

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

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

package com.project.inventory.service;

import com.project.inventory.dto.SupplierDto;

public interface SupplierService {

    SupplierDto createUser(SupplierDto supplierDto);
    SupplierDto updateUser(SupplierDto supplierDto);
    SupplierDto getSupplierBySupplierId(String id);
    SupplierDto getSupplierBySupplierName(String name);
    void deleteSupplier(String id);
}

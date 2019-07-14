package com.project.inventory.repository;

import com.project.inventory.entity.SupplierEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<SupplierEntity,Long> {

    SupplierEntity findBySupplierId(String id);
    SupplierEntity findBySupplierName(String name);
}

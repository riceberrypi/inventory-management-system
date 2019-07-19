package com.project.inventory.repository;

import com.project.inventory.entity.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,Long>{
    ProductEntity findByProductId(String id);
    ProductEntity findByProductName(String name);
}

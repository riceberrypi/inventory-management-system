package com.project.inventory.repository;

import com.project.inventory.entity.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryName(String name);
    CategoryEntity findByCategoryId(String id);
}

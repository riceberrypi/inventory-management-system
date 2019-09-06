package com.project.inventory.serviceimpl;

import com.project.inventory.dto.CategoryDto;
import com.project.inventory.entity.CategoryEntity;
import com.project.inventory.repository.CategoryRepository;
import com.project.inventory.service.CategoryService;
import com.project.inventory.utils.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IdGenerator idGenerator;

    @Transactional
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = modelMapper.map(categoryDto,CategoryEntity.class);

        categoryEntity.setCategoryId(idGenerator.generateId());

        if(categoryRepository.findByCategoryName(categoryDto.getCategoryName()) != null)
            throw new RuntimeException("Category exists!");

        CategoryEntity categoryValue = categoryRepository.save(categoryEntity);

        CategoryDto returnValue = modelMapper.map(categoryValue,CategoryDto.class);

        return returnValue;
    }

    @Transactional
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryDto.getCategoryId());
        CategoryDto returnValue;

        if(Objects.nonNull(categoryEntity)){
            categoryEntity.setCategoryName(categoryDto.getCategoryName());
            categoryEntity.setCategoryDescription(categoryDto.getCategoryDescription());

            CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
            returnValue = modelMapper.map(updatedCategory,CategoryDto.class);
        }else{
            throw new RuntimeException("Record does not exist");
        }

        return returnValue;
    }

    @Transactional
    @Override
    public CategoryDto getCategoryById(String id) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryId(id);
        CategoryDto categoryDto;
        if(Objects.nonNull(categoryEntity))
            categoryDto = modelMapper.map(categoryEntity,CategoryDto.class);
        else
            throw new RuntimeException("Record does not exist");

        return categoryDto;
    }

    @Transactional
    @Override
    public CategoryDto getCategoryByName(String name) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryName(name);
        CategoryDto categoryDto;

        if(Objects.nonNull(categoryEntity))
            categoryDto = modelMapper.map(categoryEntity,CategoryDto.class);
        else
            throw new RuntimeException("Record does not exist");

        return categoryDto;
    }

    @Transactional
    @Override
    public void deleteCategory(String id) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryId(id);

        if(Objects.nonNull(categoryEntity))
            categoryRepository.delete(categoryEntity);
        else
            throw new RuntimeException("Record does not exist!");
    }

    @Override
    public List<CategoryEntity> findAll() {
        return null;
    }


}

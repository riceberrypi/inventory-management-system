package com.project.inventory.serviceimpl;

import com.project.inventory.dto.ProductDto;
import com.project.inventory.entity.CategoryEntity;
import com.project.inventory.entity.ProductEntity;
import com.project.inventory.entity.SupplierEntity;
import com.project.inventory.repository.CategoryRepository;
import com.project.inventory.repository.ProductRepository;
import com.project.inventory.repository.SupplierRepository;
import com.project.inventory.service.ProductService;
import com.project.inventory.utils.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    ModelMapper modelMapper;

    @Transactional(readOnly = true)
    @Override
    public ProductDto getProductById(String id) {
        ProductEntity productEntity = productRepository.findByProductId(id);
        ProductDto productDto;

        if(Objects.nonNull(productEntity))
            productDto = modelMapper.map(productEntity, ProductDto.class);
        else
            throw new RuntimeException("Product not found!");


        return productDto;
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDto getProductByName(String name) {
        ProductEntity productEntity = productRepository.findByProductName(name);
        ProductDto productDto;

        if(Objects.nonNull(productEntity))
             productDto = modelMapper.map(productEntity,ProductDto.class);
        else
            throw new RuntimeException("Product not found!");

        return productDto;
    }

    @Transactional
    @Override
    public ProductDto createProduct(ProductDto productDto) {

        if(productRepository.findByProductName(productDto.getProductName()) != null)
            throw new RuntimeException("Product already exists!");

        ProductEntity productEntity = new ProductEntity(productDto);
        productEntity.setProductId(idGenerator.generateId());

        productEntity.setCategoryEntity(new CategoryEntity(productDto.getCategoryDto().getCategoryId()));
        productEntity.setSupplierEntity(new SupplierEntity(productDto.getSupplierDto().getSupplierId()));

        ProductEntity storedProductDetails = productRepository.save(productEntity);

        ProductDto createdProduct = modelMapper.map(storedProductDetails,ProductDto.class);

        return createdProduct;
    }

    @Transactional
    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        ProductEntity productEntity = productRepository.findByProductId(productDto.getProductId());

        ProductDto returnProductDto;
        if(Objects.nonNull(productEntity)){
            productEntity.setProductLabel(productDto.getProductLabel());
            productEntity.setProductName(productDto.getProductName());

            ProductEntity storedProductDetails = productRepository.save(productEntity);

            returnProductDto = modelMapper.map(storedProductDetails,ProductDto.class);
        }else{
            throw new RuntimeException("Product not found!");
        }

        return returnProductDto;
    }

    @Transactional
    @Override
    public void deleteProduct(String id) {
        ProductEntity productEntity = productRepository.findByProductId(id);
        if(Objects.nonNull(productEntity))
            productRepository.delete(productEntity);
        else
            throw new RuntimeException("Product not found!");
    }
}

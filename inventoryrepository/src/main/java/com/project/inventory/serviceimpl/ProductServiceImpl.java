package com.project.inventory.serviceimpl;

import com.project.inventory.dto.ProductDto;
import com.project.inventory.entity.ProductEntity;
import com.project.inventory.repository.ProductRepository;
import com.project.inventory.service.ProductService;
import com.project.inventory.utils.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    ModelMapper modelMapper;

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
        ProductEntity productEntity = modelMapper.map(productDto,ProductEntity.class);
        productEntity.setProductId(idGenerator.generateId());

        if(productRepository.findByProductName(productDto.getProductName()) != null)
            throw new RuntimeException("Product already exists!");

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

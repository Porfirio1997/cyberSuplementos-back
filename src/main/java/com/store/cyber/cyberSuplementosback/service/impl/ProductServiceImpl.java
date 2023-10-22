package com.store.cyber.cyberSuplementosback.service.impl;

import com.store.cyber.cyberSuplementosback.domain.model.Product;
import com.store.cyber.cyberSuplementosback.domain.repository.ProductRepository;
import com.store.cyber.cyberSuplementosback.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product create(Product productSave) {
        if (productRepository.existsByGTIN(productSave.getGTIN()) ){
            throw new IllegalArgumentException("Product GTIN already exists");
        }

        return productRepository.save(productSave);
    }
}

package com.store.cyber.cyberSuplementosback.service;

import com.store.cyber.cyberSuplementosback.domain.model.Product;

public interface ProductService {

    Product findById(Long id);

    Product create(Product product);
}

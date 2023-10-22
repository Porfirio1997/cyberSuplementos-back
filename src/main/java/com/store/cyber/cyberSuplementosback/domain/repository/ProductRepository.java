package com.store.cyber.cyberSuplementosback.domain.repository;

import com.store.cyber.cyberSuplementosback.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByGTIN(String GTIN);
}

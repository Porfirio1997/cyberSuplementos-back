package com.store.cyber.cyberSuplementosback.controller;

import com.store.cyber.cyberSuplementosback.domain.model.Product;
import com.store.cyber.cyberSuplementosback.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id){
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create( @RequestBody Product productSave){
        var productCreated = productService.create(productSave);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(location).body(productCreated);
    }


}

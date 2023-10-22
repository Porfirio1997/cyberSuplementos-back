package com.store.cyber.cyberSuplementosback.controller;

import com.store.cyber.cyberSuplementosback.domain.model.Sales;
import com.store.cyber.cyberSuplementosback.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> findByID(@PathVariable Long id){
        Sales sale = salesService.findById(id);
        return ResponseEntity.ok(sale);
    }

    @PostMapping
    public ResponseEntity<Sales> create( @RequestBody Sales salesSaving){
        Sales productCreated = salesService.create(salesSaving);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(location).body(productCreated);
    }


}

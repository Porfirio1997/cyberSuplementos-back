package com.store.cyber.cyberSuplementosback.controller;

import com.store.cyber.cyberSuplementosback.domain.model.Customer;
import com.store.cyber.cyberSuplementosback.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customerSaving){
        Customer customerCreated = customerService.create(customerSaving);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customerCreated.getId()).toUri();
        return ResponseEntity.created(location).body(customerCreated);
    }

}

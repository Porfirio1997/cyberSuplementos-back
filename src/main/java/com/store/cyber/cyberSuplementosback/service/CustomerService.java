package com.store.cyber.cyberSuplementosback.service;

import com.store.cyber.cyberSuplementosback.domain.model.Customer;

public interface CustomerService {
    Customer findById(Long id);
    Customer create(Customer customer);
}

package com.store.cyber.cyberSuplementosback.service.impl;

import com.store.cyber.cyberSuplementosback.domain.model.Customer;
import com.store.cyber.cyberSuplementosback.domain.repository.CustomerRepository;
import com.store.cyber.cyberSuplementosback.service.CustomerService;

import java.util.NoSuchElementException;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer findById(Long id) {

        return customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Customer create(Customer customer) {
        if (customerRepository.existsById(customer.getId()) ){
            throw new IllegalArgumentException("Customer already exists");
        }

        return customerRepository.save(customer);
    }
}

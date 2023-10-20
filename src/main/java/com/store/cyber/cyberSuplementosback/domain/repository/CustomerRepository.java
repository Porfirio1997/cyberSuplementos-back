package com.store.cyber.cyberSuplementosback.domain.repository;

import com.store.cyber.cyberSuplementosback.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
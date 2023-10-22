package com.store.cyber.cyberSuplementosback.service;

import com.store.cyber.cyberSuplementosback.domain.model.Sales;

public interface SalesService {

    Sales findById(Long id);
    Sales create(Sales sales);
}

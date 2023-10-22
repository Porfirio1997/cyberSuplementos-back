package com.store.cyber.cyberSuplementosback.service.impl;

import com.store.cyber.cyberSuplementosback.domain.model.Sales;
import com.store.cyber.cyberSuplementosback.domain.repository.SalesRepository;
import com.store.cyber.cyberSuplementosback.service.SalesService;

import java.util.NoSuchElementException;

public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public Sales findById(Long id) {
        return salesRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Sales create(Sales sales) {
        if (salesRepository.existsById(sales.getId()) ){
            throw new IllegalArgumentException("Sale already exists");
        }

        return salesRepository.save(sales);
    }
}

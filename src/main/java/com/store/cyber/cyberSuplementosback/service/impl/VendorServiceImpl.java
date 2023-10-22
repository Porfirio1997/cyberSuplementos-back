package com.store.cyber.cyberSuplementosback.service.impl;

import com.store.cyber.cyberSuplementosback.domain.model.Vendor;
import com.store.cyber.cyberSuplementosback.domain.repository.VendorRepository;
import com.store.cyber.cyberSuplementosback.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }


    @Override
    public Vendor findById(Long id) {
        return vendorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Vendor create(Vendor vendor) {
        if (vendorRepository.existsById(vendor.getId()) ){
            throw new IllegalArgumentException("Vendor already exists");
        }

        return vendorRepository.save(vendor);
    }
}

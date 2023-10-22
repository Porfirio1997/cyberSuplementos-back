package com.store.cyber.cyberSuplementosback.service;

import com.store.cyber.cyberSuplementosback.domain.model.Vendor;

public interface VendorService {
    Vendor findById(Long id);
    Vendor create(Vendor vendor);
}

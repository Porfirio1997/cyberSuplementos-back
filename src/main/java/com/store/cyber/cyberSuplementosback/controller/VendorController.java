package com.store.cyber.cyberSuplementosback.controller;

import com.store.cyber.cyberSuplementosback.domain.model.Sales;
import com.store.cyber.cyberSuplementosback.domain.model.Vendor;
import com.store.cyber.cyberSuplementosback.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> findByID(@PathVariable Long id){
        Vendor vendor = vendorService.findById(id);
        return ResponseEntity.ok(vendor);
    }

    @PostMapping
    public ResponseEntity<Vendor> create( @RequestBody Vendor vendorSaving){
        Vendor vendorCreated = vendorService.create(vendorSaving);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendorCreated.getId()).toUri();
        return ResponseEntity.created(location).body(vendorCreated);
    }

}

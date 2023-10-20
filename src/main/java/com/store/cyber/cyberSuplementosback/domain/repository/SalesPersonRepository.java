package com.store.cyber.cyberSuplementosback.domain.repository;

import com.store.cyber.cyberSuplementosback.domain.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPersonRepository extends JpaRepository<Vendor,Long> {
}

package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.AdditionalAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalAddressRepo extends JpaRepository<AdditionalAddress, String> {
}

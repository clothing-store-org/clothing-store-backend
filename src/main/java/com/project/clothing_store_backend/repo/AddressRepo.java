package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, String> {
}

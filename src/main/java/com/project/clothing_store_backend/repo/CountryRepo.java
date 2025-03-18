package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, String> {
}

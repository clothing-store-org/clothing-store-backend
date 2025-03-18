package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, String> {
}

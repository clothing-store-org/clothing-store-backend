package com.project.clothing_store_backend.repo;


import com.project.clothing_store_backend.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, String> {
}

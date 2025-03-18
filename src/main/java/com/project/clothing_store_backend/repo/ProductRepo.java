package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}

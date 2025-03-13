package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, String> {
}

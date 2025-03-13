package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, String> {
}

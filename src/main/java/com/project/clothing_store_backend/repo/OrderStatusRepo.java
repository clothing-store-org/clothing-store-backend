package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, String> {
}

package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, String> {
}

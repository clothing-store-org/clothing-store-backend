package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, String> {
}

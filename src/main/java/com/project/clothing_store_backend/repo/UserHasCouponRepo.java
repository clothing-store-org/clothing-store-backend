package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.UserHasCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasCouponRepo extends JpaRepository<UserHasCoupon, String> {
}

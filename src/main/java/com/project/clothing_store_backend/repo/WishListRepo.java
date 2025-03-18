package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList, String> {
}

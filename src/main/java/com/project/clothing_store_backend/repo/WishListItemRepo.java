package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListItemRepo extends JpaRepository<WishListItem, String> {
}

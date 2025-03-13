package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {
}

package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}

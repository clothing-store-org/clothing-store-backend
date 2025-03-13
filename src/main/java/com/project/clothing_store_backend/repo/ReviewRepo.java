package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, String> {
}

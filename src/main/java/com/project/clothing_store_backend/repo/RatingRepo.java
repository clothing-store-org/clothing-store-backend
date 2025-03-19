package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {
}

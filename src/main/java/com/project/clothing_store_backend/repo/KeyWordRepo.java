package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordRepo extends JpaRepository<KeyWord, String> {
}

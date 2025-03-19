package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, String> {
}

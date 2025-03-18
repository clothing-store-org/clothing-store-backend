package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, String> {
}

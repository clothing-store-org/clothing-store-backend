package com.project.clothing_store_backend.repo.auth;

import com.project.clothing_store_backend.entity.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserRoleRepo extends JpaRepository<UserRole,String> {
    @Query(value = "SELECT * FROM user_role WHERE role_name=?1 LIMIT 1",nativeQuery = true)
    public Optional<UserRole> findByRoleName(String role);

    @Query(value = "SELECT * FROM user_role WHERE (role_name LIKE %?1%)", nativeQuery = true)
    List<UserRole> findAllUserRoleBySearchText(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM user_role WHERE (role_name LIKE %?1%)", nativeQuery = true)
    long countAllBySearchText(String searchText);
}

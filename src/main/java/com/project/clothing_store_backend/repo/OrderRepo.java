package com.project.clothing_store_backend.repo;

import com.project.clothing_store_backend.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {
    @Query(value = "SELECT * FROM orders WHERE netTotal LIKE %?1%, address LIKE %?1% ",nativeQuery = true)
    public Page<Order> findAllWithSearchText(String searchText, Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM orders WHERE netTotal LIKE %?1%,address LIKE %?1% ",nativeQuery = true)
    public long countAllWithSearchText(String searchText);
}

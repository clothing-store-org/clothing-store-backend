package com.project.clothing_store_backend.service.auth.impl;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestOrderDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseOrderDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedOrderDto;
import com.project.clothing_store_backend.entity.Order;
import com.project.clothing_store_backend.repo.OrderRepo;
import com.project.clothing_store_backend.service.auth.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public void create(RequestOrderDto dto) {
        Order order = Order.builder()
                .property_id(UUID.randomUUID().toString())
                .netTotal(dto.getNetTotal())
                .createdAt(LocalDateTime.now())
                .additionalAddress(dto.getAdditionalAddress())
                .address(dto.getAddress())
                .build();
        orderRepo.save(order);
    }

    @Override
    public void update(String id,RequestOrderDto dto) {
        Optional<Order> selectedOrder = orderRepo.findById(id);
        if (selectedOrder.isEmpty()){
            throw new RuntimeException("Order Not Found");
        }
        Order order = selectedOrder.get();
        order.setAddress(dto.getAddress());
        order.setAdditionalAddress(dto.getAdditionalAddress());
        order.setNetTotal(dto.getNetTotal());
        orderRepo.save(order);
    }

    @Override
    public ResponseOrderDto getById(String id) {
        Optional<Order> selectedOrder = orderRepo.findById(id);
        if (selectedOrder.isEmpty()){
            throw new RuntimeException("Order Not Found");
        }
        return toResponseOrder(selectedOrder.get());
    }

    @Override
    public void delete(String id) {
        orderRepo.deleteById(id);
    }

    @Override
    public PaginatedOrderDto getAll(String searchText, int page, int size) {
        return PaginatedOrderDto.builder()
                .dataList(orderRepo.findAllWithSearchText(searchText, PageRequest.of(page, size)).stream().map(this::toResponseOrder).toList())
                .count(
                        orderRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    private ResponseOrderDto toResponseOrder(Order order){
        return ResponseOrderDto.builder()
                .property_id(order.getProperty_id())
                .netTotal(order.getNetTotal())
                .createdAt(LocalDateTime.now())
                .additionalAddress(order.getAdditionalAddress())
                .address(order.getAddress())
                .build();
    }
}

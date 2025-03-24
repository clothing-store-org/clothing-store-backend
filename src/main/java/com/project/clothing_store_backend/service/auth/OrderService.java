package com.project.clothing_store_backend.service.auth;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestOrderDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseOrderDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedOrderDto;

public interface OrderService {
    public void create(RequestOrderDto dto);
    public void update(String id, RequestOrderDto dto );
    public ResponseOrderDto getById(String id);
    public void delete(String id);
    public PaginatedOrderDto getAll(String searchText, int page, int size);
}

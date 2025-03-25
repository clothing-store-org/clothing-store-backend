package com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaginatedOrderDto {
    private long count;
    private List<ResponseOrderDto> dataList;
}

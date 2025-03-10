package com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto;

import com.project.clothing_store_backend.dto.response_dto.auth.ResponseApplicationUserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedUserResponseDto {
    private List<ResponseApplicationUserDto> dataList;
    private long count;
}
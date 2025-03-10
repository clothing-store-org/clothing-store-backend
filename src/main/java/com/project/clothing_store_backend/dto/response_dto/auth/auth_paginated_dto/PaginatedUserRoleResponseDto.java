package com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto;

import com.project.clothing_store_backend.dto.response_dto.auth.ResponseUserRoleDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaginatedUserRoleResponseDto {
    private Long count;
    private List<ResponseUserRoleDto> dataList;
}

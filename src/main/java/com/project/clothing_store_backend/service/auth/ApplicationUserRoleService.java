package com.project.clothing_store_backend.service.auth;

import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserRoleDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseUserRoleDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedUserRoleResponseDto;

public interface ApplicationUserRoleService {
    public void initializeRoles();

    void createUserRole(RequestUserRoleDto dto);

    void modifyUserRole(RequestUserRoleDto dto, String userRoleId);

    void deleteUserRole(String userRoleId);

    PaginatedUserRoleResponseDto findAllUserRole(int page, int size, String searchText);


    ResponseUserRoleDto findUserRole(String userRoleId);
}

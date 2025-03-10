package com.project.clothing_store_backend.service.auth;

import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserDto;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserPasswordResetDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseApplicationUserDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedUserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.sql.SQLException;

public interface ApplicationUserService extends UserDetailsService {
    public void createSystemUser(RequestUserDto dto) throws IOException;
    public void initializeAdmin();
    public void addNewRoleToUser(String email,String role);
}

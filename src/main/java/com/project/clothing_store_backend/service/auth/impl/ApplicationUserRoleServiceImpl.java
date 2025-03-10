package com.project.clothing_store_backend.service.auth.impl;

import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserRoleDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseUserRoleDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedUserRoleResponseDto;
import com.project.clothing_store_backend.entity.UserRole;
import com.project.clothing_store_backend.exception.DuplicateEntryException;
import com.project.clothing_store_backend.exception.EntryNotFoundException;
import com.project.clothing_store_backend.repo.auth.ApplicationUserRoleRepo;
import com.project.clothing_store_backend.service.auth.ApplicationUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationUserRoleServiceImpl implements ApplicationUserRoleService {
private final ApplicationUserRoleRepo userRoleRepo;

    @Override
    public void initializeRoles() {
        List<UserRole> applicationUserRoles = userRoleRepo.findAll();
        if (applicationUserRoles.isEmpty()){
            UserRole admin = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("ADMIN")
                    .build();
            UserRole customer = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("CUSTOMER")
                    .build();
            UserRole adminController = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("ADMIN_CONTROLLER")
                    .build();
            userRoleRepo.saveAll(List.of(admin,customer,adminController));
        }
    }

    @Override
    public void createUserRole(RequestUserRoleDto dto) {
        Optional<UserRole> existsData = userRoleRepo.findByRoleName(dto.getRoleName());
        if(existsData.isPresent()){
            throw new DuplicateEntryException("Role name already exists");
        }

        userRoleRepo.save(
                UserRole.builder().roleId(UUID.randomUUID().toString()).roleName(dto.getRoleName()).build()
        );
    }

    @Override
    public void modifyUserRole(RequestUserRoleDto dto, String userRoleId) {
        Optional<UserRole> userRoleRepoById = userRoleRepo.findById(userRoleId);
        if (userRoleRepoById.isPresent()){
            userRoleRepoById.get().setRoleName(dto.getRoleName());
            userRoleRepo.save(userRoleRepoById.get());
        }else {
            throw new EntryNotFoundException("Can't fine user role");
        }

    }

    @Override
    public void deleteUserRole(String userRoleId) {

        if (userRoleRepo.existsById(userRoleId)){
            userRoleRepo.deleteById(userRoleId);
        }else {
            throw new EntryNotFoundException("Can't fine user role");
        }

    }

    @Override
    public PaginatedUserRoleResponseDto findAllUserRole(int page, int size, String searchText) {
        List<UserRole> allWithPagination =
                userRoleRepo.findAllUserRoleBySearchText(searchText, PageRequest.of(page, size));
        long count = userRoleRepo.countAllBySearchText(searchText);
        ArrayList<ResponseUserRoleDto> dtos = new ArrayList<>();
        for (UserRole role : allWithPagination) {
            dtos.add(new ResponseUserRoleDto(role.getRoleId(), role.getRoleName()));
        }
        return new PaginatedUserRoleResponseDto(
                count,
                dtos
        );
    }

    @Override
    public ResponseUserRoleDto findUserRole(String userRoleId) {
        Optional<UserRole> userRole = userRoleRepo.findById(userRoleId);
        if(userRole.isPresent()){
            return new ResponseUserRoleDto(userRole.get().getRoleId(),userRole.get().getRoleName());
        }else {
            throw new EntryNotFoundException("Can't find User Role");
        }

    }
}

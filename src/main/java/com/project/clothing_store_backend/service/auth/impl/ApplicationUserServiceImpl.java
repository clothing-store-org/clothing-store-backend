package com.project.clothing_store_backend.service.auth.impl;

import com.project.clothing_store_backend.dto.request_dto.auth.RequestApplicationUserLoginDto;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserDto;
import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserPasswordResetDto;
import com.project.clothing_store_backend.dto.response_dto.auth.ResponseApplicationUserDto;
import com.project.clothing_store_backend.dto.response_dto.auth.auth_paginated_dto.PaginatedUserResponseDto;
import com.project.clothing_store_backend.entity.ApplicationUser;
import com.project.clothing_store_backend.entity.UserRole;
import com.project.clothing_store_backend.exception.DuplicateEntryException;
import com.project.clothing_store_backend.exception.EntryNotFoundException;
import com.project.clothing_store_backend.repo.auth.ApplicationUserRepo;
import com.project.clothing_store_backend.repo.auth.ApplicationUserRoleRepo;
import com.project.clothing_store_backend.security.SupportSpringApplicationUser;
import com.project.clothing_store_backend.service.auth.ApplicationUserService;
import com.project.clothing_store_backend.util.OtpGenerator;
import com.project.clothing_store_backend.util.StrongPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static com.project.clothing_store_backend.security.ApplicationUserRole.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private final ApplicationUserRepo applicationUserRepo;
    private final StrongPasswordGenerator strongPasswordGenerator;
    private final ApplicationUserRoleRepo applicationUserRoleRepo;
    private final PasswordEncoder passwordEncoder;
    private final SecretKey secretKey;
    private final OtpGenerator otpGenerator;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> selectedUserData = applicationUserRepo.findByUsername(username);
        if (selectedUserData.isEmpty()) {
            throw new EntryNotFoundException(String.format("username %s not found", username));
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole u : selectedUserData.get().getRoles()) {
            if (u.getRoleName().equals("ADMIN")) {
                grantedAuthorities.addAll(ADMIN.getGrantedAuthorities());
            }
            if (u.getRoleName().equals("CUSTOMER")) {
                grantedAuthorities.addAll(CUSTOMER.getGrantedAuthorities());
            }
            if (u.getRoleName().equals("ADMIN_CONTROLLER")) {
                grantedAuthorities.addAll(ADMIN_CONTROLLER.getGrantedAuthorities());
            }

        }

        return new SupportSpringApplicationUser(
                selectedUserData.get().getUsername(),
                selectedUserData.get().getPassword(),
                selectedUserData.get().isAccountNonExpired(),
                selectedUserData.get().isAccountNonLocked(),
                selectedUserData.get().isCredentialsNonExpired(),
                selectedUserData.get().isEnabled(),
                grantedAuthorities
        );

    }

    @Override
    public void createSystemUser(RequestUserDto dto) {
        Optional<ApplicationUser> selectedUser = applicationUserRepo.findByUsername(dto.getUsername());
        if (selectedUser.isPresent()) {
            throw new EntryNotFoundException(String.format("username %s already exist", dto.getUsername()));
        }
        applicationUserRepo.save(createApplicationUser(dto));
    }

    @Override
    public void initializeAdmin() {
        Optional<ApplicationUser> selectedUser
                = applicationUserRepo.findByUsername("admin@gmail.com");
        if (selectedUser.isPresent()) {
            return;
        }

        Optional<UserRole> selectedRole = applicationUserRoleRepo.findByRoleName("ADMIN");
        if (selectedRole.isEmpty()) {
            throw new EntryNotFoundException("role not found.");
        }

        Set<UserRole> selectedRoles = new HashSet<>();
        selectedRoles.add(selectedRole.get());

//        emailService.notifyUser("User Password", "hasikasandaruwan.info@gmail.com", pw);
        applicationUserRepo.save(
                ApplicationUser.builder()
                        .userId(UUID.randomUUID().toString())
                        .username("admin@gmail.com")
                        .password(passwordEncoder.encode("1234")) // must be encrypted //
                        .baseCountry("Sri Lanka")
                        .contact("0767298181")
                        .fullName("Kasun Fernando")
                        .dob(new Date())
                        .gender("MALE")
                        .roles(selectedRoles)
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isEnabled(true).build()
        );
    }

    private ApplicationUser createApplicationUser(RequestUserDto dto) {
        if (dto == null) {
            throw new EntryNotFoundException("something went wrong..");
        }
        Optional<UserRole> selectedRole = applicationUserRoleRepo.findByRoleName(dto.getRole());
        if (selectedRole.isEmpty()) {
            throw new EntryNotFoundException("role not found.");
        }
//        String pwd = strongPasswordGenerator.generatePassword(6);
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(selectedRole.get());
//        System.out.println(pwd);
//        emailService.notifyUser("User Password", dto.getUsername(), pwd);
        return ApplicationUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(dto.getUsername().trim())
                .dob(dto.getDob())
                .gender(dto.getGender())
                .contact(dto.getContact())
                .password(passwordEncoder.encode(dto.getPassword())) // must be encrypted
                .fullName(dto.getFullName().trim())
                .baseCountry(dto.getCountry().trim())
                .contact(dto.getContact().trim())
                .roles(userRoles)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true).build();

    }

    @Override
    public void addNewRoleToUser(String email, String role) {
        Optional<UserRole> selectedUserRole = applicationUserRoleRepo.findById(role);
        if (selectedUserRole.isEmpty()) {
            throw new IllegalStateException("User Role not found!");
        }
        Optional<ApplicationUser> selectedUser = applicationUserRepo.findByUsername(email);
        if (selectedUser.isEmpty()) {
            throw new IllegalStateException("User not found!");
        }
        selectedUser.get().getRoles().add(selectedUserRole.get());
        applicationUserRepo.save(selectedUser.get());
    }
}

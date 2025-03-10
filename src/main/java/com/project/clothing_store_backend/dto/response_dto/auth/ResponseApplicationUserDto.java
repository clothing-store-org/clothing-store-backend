package com.project.clothing_store_backend.dto.response_dto.auth;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApplicationUserDto {
    private String username;
    private String fullName;
    private String baseCountry;
    private String contact;
    private boolean isEnabled;
    private List<String> roles;
}
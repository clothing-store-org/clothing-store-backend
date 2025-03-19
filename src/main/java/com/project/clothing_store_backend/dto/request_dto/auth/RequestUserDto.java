package com.project.clothing_store_backend.dto.request_dto.auth;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestUserDto {
    private String username;
    private String password;
    private String fullName;
    private String contact;
    private String country;
    private String role;
    private LocalDateTime dob;
    private String gender;
}

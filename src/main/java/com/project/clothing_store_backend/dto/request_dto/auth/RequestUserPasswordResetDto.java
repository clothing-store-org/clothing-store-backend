package com.project.clothing_store_backend.dto.request_dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RequestUserPasswordResetDto {
    private String email;
    private String code;
    private String password;
}

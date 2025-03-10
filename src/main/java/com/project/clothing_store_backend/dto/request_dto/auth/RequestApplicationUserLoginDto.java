package com.project.clothing_store_backend.dto.request_dto.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestApplicationUserLoginDto {
    private String username;
    private String password;
}

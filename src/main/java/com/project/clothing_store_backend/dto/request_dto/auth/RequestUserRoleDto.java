package com.project.clothing_store_backend.dto.request_dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RequestUserRoleDto {
    private String roleName;
}

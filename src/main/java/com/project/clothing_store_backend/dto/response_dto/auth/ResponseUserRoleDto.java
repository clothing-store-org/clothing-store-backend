package com.project.clothing_store_backend.dto.response_dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseUserRoleDto {
    private String roleId;
    private String roleName;
}

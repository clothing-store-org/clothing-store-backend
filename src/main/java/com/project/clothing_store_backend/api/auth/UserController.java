package com.project.clothing_store_backend.api.auth;

import com.project.clothing_store_backend.dto.request_dto.auth.RequestUserDto;
import com.project.clothing_store_backend.service.auth.ApplicationUserService;
import com.project.clothing_store_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/application_user")
@RequiredArgsConstructor
public class UserController {
    private final ApplicationUserService applicationUserService;

    @PostMapping("/visitor/register")
    public ResponseEntity<StandardResponse> register(@RequestBody RequestUserDto dto) throws IOException {
        applicationUserService.createSystemUser(dto);
        return new ResponseEntity<>(
                StandardResponse.builder()
                        .code(201)
                        .message("User Registered")
                        .data(null)
                        .build(),
                HttpStatus.CREATED
        );
    }
}

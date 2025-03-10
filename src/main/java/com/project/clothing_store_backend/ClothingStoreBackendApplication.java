package com.project.clothing_store_backend;

import com.project.clothing_store_backend.service.auth.ApplicationUserRoleService;
import com.project.clothing_store_backend.service.auth.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ClothingStoreBackendApplication implements CommandLineRunner {
    private final ApplicationUserRoleService applicationUserRoleService;
    private final ApplicationUserService applicationUserService;

    public static void main(String[] args) {
        SpringApplication.run(ClothingStoreBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        applicationUserRoleService.initializeRoles();
        applicationUserService.initializeAdmin();
    }
}

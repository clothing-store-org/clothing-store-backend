package com.project.clothing_store_backend.dto.response_dto.auth;
import com.project.clothing_store_backend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseOrderDto {
    private String property_id;
    private LocalDateTime createdAt;
    private double netTotal;
    private Address address;
    private AdditionalAddress additionalAddress;

}

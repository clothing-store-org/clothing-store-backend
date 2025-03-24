package com.project.clothing_store_backend.dto.request_dto.auth;

import com.project.clothing_store_backend.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestOrderDto {
    private double netTotal;
    private Address address;
    private AdditionalAddress additionalAddress;
}

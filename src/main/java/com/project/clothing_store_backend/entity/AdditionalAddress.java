package com.project.clothing_store_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "additional_address")
public class AdditionalAddress {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "address_line_1", nullable = false, length = 255)
    private String address_line_1;
    @Column(name = "address_line_2", nullable = false, length = 255)
    private String address_line_2;
    @Column(name = "postal_code", nullable = false, length = 20)
    private String postal_code;
    @Column(name = "city_id", nullable = false, length = 80)
    private String city_id;
    @Column(name = "user_id", nullable = false, length = 80)
    private String user_id;
}

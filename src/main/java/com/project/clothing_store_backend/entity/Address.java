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
@Entity(name = "address")
public class Address {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "address_line_1", nullable = false, length = 255)
    private String address_line_1;
    @Column(name = "address_line_2", nullable = false, length = 255)
    private String address_line_2;
    @Column(name = "postal_code", nullable = false, length = 20)
    private int postal_code;
    @Column(name = "delivery_fee", nullable = false)
    private double delivery_fee;
    @Column(name = "city_id", nullable = false, length = 80)
    private String city_id;
}

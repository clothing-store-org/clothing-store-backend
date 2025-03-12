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
@Entity(name = "city")
public class City {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "city_name", nullable = false, length = 255)
    private String city_name;
    @Column(name = "district_id", nullable = false, length = 80)
    private String district_id;
}

package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<AdditionalAddress> additionalAddresses;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<Address> addresses;
    @ManyToOne
    @JoinColumn(name = "district",nullable = false)
    private District district;
}

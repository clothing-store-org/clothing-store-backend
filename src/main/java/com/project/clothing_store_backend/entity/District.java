package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "district")
public class District {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "district_name", nullable = false, length = 255)
    private String district_name;

//    new

    @ManyToOne
    @JoinColumn(name = "province_id",nullable = false)
    private Province province;

    @OneToMany(mappedBy = "district",fetch = FetchType.LAZY)
    private List<City> cities;
}

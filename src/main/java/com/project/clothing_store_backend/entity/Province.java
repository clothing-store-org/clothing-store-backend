package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "province")
public class Province {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "province_name", nullable = false, length = 255)
    private String province_name;
    @Column(name = "country_id", nullable = false, length = 80)
    private String country_id;
    @OneToMany(mappedBy = "province",fetch = FetchType.LAZY)
    private List<Country> countries;
    @OneToMany(mappedBy = "province",fetch = FetchType.LAZY)
    private List<District> districts;
}

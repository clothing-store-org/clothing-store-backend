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
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "district_name", nullable = false, length = 255)
    private String district_name;
    @Column(name = "province_id", nullable = false, length = 80)
    private String province_id;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<District> districts;
    @ManyToOne
    @JoinColumn(name = "province",nullable = false)
    private Province province;
}

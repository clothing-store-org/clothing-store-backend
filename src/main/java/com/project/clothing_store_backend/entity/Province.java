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
    @Column(name = "property_id", nullable = false,unique = true)
    private String property_id;

    @Column(name = "province_name", nullable = false, length = 255)
    private String province_name;

//    new

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;

    @OneToMany(mappedBy = "province",fetch = FetchType.LAZY)
    private List<District> districts;
}

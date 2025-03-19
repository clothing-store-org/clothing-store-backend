package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "country")
public class Country {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "country_name", nullable = false, length = 255)
    private String country_name;

//    new

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    private List<Province> provinces;
}

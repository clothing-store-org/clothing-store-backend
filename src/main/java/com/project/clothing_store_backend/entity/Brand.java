package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "brands")
public class Brand {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "brand_name", nullable = false, length = 255)
    private String brand_name;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    private List<Product> products;

}

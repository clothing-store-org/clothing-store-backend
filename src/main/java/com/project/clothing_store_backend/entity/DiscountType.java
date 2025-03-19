package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "discount_type")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DiscountType {
    @Id
    @Column(name = "property_id",nullable = false,unique = true)
    private String propertyId;

    @Column(name = "type_name",nullable = false,unique = true)
    private String type_name;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "discountType",fetch = FetchType.LAZY)
    private List<Discount> discounts;
}

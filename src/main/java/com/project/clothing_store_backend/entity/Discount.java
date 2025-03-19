package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "discount")
public class Discount {
    @Id
    @Column(name = "property_id", nullable = false)
    private String propertyId;

    @Column(name = "discount_rate", nullable = false)
    private double discountRate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "discount_type_id",nullable = false)
    private DiscountType discountType;

    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY)
    private List<ProductHasDiscount> productHasDiscounts;
}

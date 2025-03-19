package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_has_discount")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductHasDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;
}
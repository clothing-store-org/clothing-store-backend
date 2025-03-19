package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "cart_item")
public class CartItem {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "product_title", nullable = false, length = 255)
    private String product_title;

    @Column(name = "product_description", nullable = false, length = 255)
    private String product_description;

    @Column(name = "unit_price", nullable = false)
    private double unit_price;

    @Column(name = "qty_on_hand", nullable = false)
    private int qty_on_hand;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}

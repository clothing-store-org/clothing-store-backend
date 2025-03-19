package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "cart_item")
public class CartItem {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "product_title", nullable = false, length = 255)
    private String product_title;
    @Column(name = "product_description", nullable = false, length = 255)
    private String product_description;
    @Column(name = "unit_price", nullable = false)
    private double unit_price;
    @Column(name = "qty_on_hand", nullable = false)
    private int qty_on_hand;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "cart_id", nullable = false, length = 80)
    private String cart_id;
    @Column(name = "product_id", nullable = false, length = 80)
    private String product_id;
    @ManyToOne
    @JoinColumn(name = "cart",nullable = false)
    private Cart cart;
    @OneToOne(mappedBy = "cartItem",fetch = FetchType.LAZY)
    private Product product;
}

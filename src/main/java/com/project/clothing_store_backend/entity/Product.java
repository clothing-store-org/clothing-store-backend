package com.project.clothing_store_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "product_title", nullable = false, length = 255)
    private String product_title;
    @Column(name = "product_description", nullable = false, length = 255)
    private String product_description;
    @Column(name = "unit_price", nullable = false)
    private double unit_price;
    @Column(name = "qty_on_hand", nullable = false, length = 80)
    private int qty_on_hand;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "brand_id", nullable = false, length = 80)
    private String brand_id;
    @Column(name = "discount_id", nullable = false, length = 80)
    private String discount_id;
}

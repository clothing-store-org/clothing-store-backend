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
@Entity(name = "item")
public class Item {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "item_title", nullable = false, length = 255)
    private String item_title;

    @Column(name = "item_description", nullable = false, length = 255)
    private String item_description;

    @Column(name = "nett_total", nullable = false,scale = 2)
    private double nett_total;

    @Column(name = "qty", nullable = false)
    private int qty;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
}

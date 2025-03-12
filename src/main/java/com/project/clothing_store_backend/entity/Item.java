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
@Entity(name = "item")
public class Item {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "item_title", nullable = false, length = 255)
    private String item_title;
    @Column(name = "item_description", nullable = false, length = 255)
    private String item_description;
    @Column(name = "nett_total", nullable = false)
    private double nett_total;
    @Column(name = "qty", nullable = false)
    private int qty;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "product_id", nullable = false, length = 80)
    private String product_id;
    @Column(name = "order_id", nullable = false, length = 80)
    private String order_id;
}

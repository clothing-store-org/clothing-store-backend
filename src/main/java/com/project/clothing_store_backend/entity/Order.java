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
@Entity(name = "order")
public class Order {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "address_id", nullable = false, length = 80)
    private String address_id;
    @Column(name = "order_status_id", nullable = false, length = 80)
    private String order_status_id;
    @Column(name = "payment", nullable = false)
    private double payment;
    @Column(name = "payment_method_id", nullable = false, length = 80)
    private String payment_method_id;
}

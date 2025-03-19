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
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "property_id", nullable = false, unique = true)
    private String property_id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "net_total",nullable = false,scale = 2)
    private double netTotal;

//    new

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "additional_address_id")
    private AdditionalAddress additionalAddress;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToOne(mappedBy = "order",fetch = FetchType.LAZY)
    private OrderTracking orderTracking;

    @OneToOne(mappedBy = "order",fetch = FetchType.LAZY)
    private Payment payment;
}

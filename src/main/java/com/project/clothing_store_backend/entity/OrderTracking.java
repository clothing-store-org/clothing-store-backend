package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "order_tracking")
public class OrderTracking {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;
    @Column(name = "order_id", nullable = false, length = 80)
    private String order_id;
    @Column(name = "order_status_id", nullable = false, length = 80)
    private String order_status_id;
    @OneToOne(mappedBy = "order-tracking" , fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "order-status",nullable = false)
    private OrderStatus orderStatus;
}

package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "order_status")
public class OrderStatus {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "type", nullable = false)
    private String type;
    @OneToMany(mappedBy = "order-status",fetch = FetchType.LAZY)
    private List<OrderTracking> orderTracking;
}

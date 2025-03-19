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
    @Column(name = "property_id", nullable = false, unique = true)
    private String property_id;

    @Column(name = "order_type", nullable = false,unique = true)
    private String order_type;

//    new

    @OneToMany(mappedBy = "orderStatus",fetch = FetchType.LAZY)
    private List<OrderTracking> orderTrackings;
}

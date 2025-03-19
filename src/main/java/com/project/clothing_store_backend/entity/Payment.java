package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "payment")
public class Payment {
    @Id
    @Column(name = "property_id", nullable = false, unique = true)
    private String property_id;

//    new

    @ManyToOne
    @JoinColumn(name = "payment_method_id",nullable = false)
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "delivery_info_id",nullable = false)
    private DeliveryInfo deliveryInfo;
}

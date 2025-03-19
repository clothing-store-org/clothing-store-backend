package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "payment_method")
public class PaymentMethod {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "type", nullable = false, length = 80)
    private String type;
    @ManyToOne
    @JoinColumn(name = "payment",nullable = false)
    private Payment payment;
}

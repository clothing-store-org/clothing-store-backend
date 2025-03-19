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
    @Column(name = "property_id", nullable = false,unique = true)
    private String property_id;

    @Column(name = "payment_method", nullable = false, unique = true)
    private String payment_method;

    @OneToMany(mappedBy = "paymentMethod",fetch = FetchType.LAZY)
    private List<Payment> payments;

}

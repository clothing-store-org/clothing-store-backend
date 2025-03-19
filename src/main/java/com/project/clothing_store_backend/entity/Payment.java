package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "payment_method_id", nullable = false, length = 80)
    private String payment_method_id;
    @Column(name = "order_id", nullable = false, length = 80)
    private String order_id;
    @Column(name = "createdAt", nullable = false, length = 80)
    private Date createdAt;
    @OneToOne(mappedBy = "payment",fetch = FetchType.LAZY)
    private Order order;
    @OneToMany(mappedBy = "payment",fetch = FetchType.LAZY)
    private List<PaymentMethod> paymentMethods;
}

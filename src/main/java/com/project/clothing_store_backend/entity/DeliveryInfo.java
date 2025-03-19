package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "delivery_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInfo {
    @Id
    @Column(name = "property_id",nullable = false, unique = true)
    private String property_id;

    @Column(name = "within_colombo_and_sub")
    private Double withinColomboAndSub;

    @Column(name = "other_cities")
    private Double otherCities;

    @Column(name = "site_pickup",columnDefinition = "TINYINT")
    private boolean sitePickUp;

    @OneToMany(mappedBy = "deliveryInfo",fetch = FetchType.LAZY)
    private List<Payment> payments;
}

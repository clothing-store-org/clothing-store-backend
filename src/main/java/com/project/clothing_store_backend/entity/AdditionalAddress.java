package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "additional_address")
public class AdditionalAddress {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "address_line_1", nullable = false, length = 255)
    private String address_line_1;

    @Column(name = "address_line_2", nullable = false, length = 255)
    private String address_line_2;

    @Column(name = "postal_code", nullable = false, length = 20)
    private int postal_code;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private ApplicationUser user;

    @OneToOne(mappedBy = "additionalAddress",fetch = FetchType.LAZY)
    private Order order;

}

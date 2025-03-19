package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "user_has_coupon")
public class UserHasCoupon {
    @Id
    private String property_id;
    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private ApplicationUser user;
    @ManyToOne
    @JoinColumn(name = "coupon",nullable = false)
    private Coupon coupon;

}

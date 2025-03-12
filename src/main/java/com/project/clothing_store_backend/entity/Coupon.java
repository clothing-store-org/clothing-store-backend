package com.project.clothing_store_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "coupon")
public class Coupon {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "coupon_code", nullable = false, length = 80)
    private String coupon_code;
    @Column(name = "end_date", nullable = false)
    private Date end_date;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
}

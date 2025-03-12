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
@Entity(name = "review")
public class Review {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "message", nullable = false, length = 80)
    private String message;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "rating_id", nullable = false, length = 80)
    private String rating_id;
    @Column(name = "product_id", nullable = false, length = 80)
    private String product_id;
}

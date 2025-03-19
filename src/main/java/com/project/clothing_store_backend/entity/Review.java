package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "review")
public class Review {
    @Id
    @Column(name = "property_id", nullable = false, unique = true)
    private String property_id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

//    new

    @OneToOne
    @JoinColumn(name = "rating_id",nullable = false)
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


}

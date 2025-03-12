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
@Entity(name = "rating")
public class Rating {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "rate_1", nullable = false, length = 80)
    private String rate_1;
    @Column(name = "rate_2", nullable = false, length = 80)
    private String rate_2;
    @Column(name = "rate_3", nullable = false, length = 80)
    private String rate_3;
    @Column(name = "rate_4", nullable = false, length = 80)
    private String rate_4;
    @Column(name = "rate_5", nullable = false, length = 80)
    private String rate_5;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
}

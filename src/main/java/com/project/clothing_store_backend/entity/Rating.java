package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "rating")
public class Rating {
    @Id
    @Column(name = "property_id", nullable = false,unique = true)
    private String property_id;

    @Column(name = "star_1", nullable = false)
    private int star_1;

    @Column(name = "star_2", nullable = false)
    private int star_2;

    @Column(name = "star_3", nullable = false)
    private int star_3;

    @Column(name = "star_4", nullable = false)
    private int star_4;

    @Column(name = "star_5", nullable = false)
    private int star_5;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

//    new

    @OneToOne(mappedBy = "rating",fetch = FetchType.LAZY)
    private Review review;

}

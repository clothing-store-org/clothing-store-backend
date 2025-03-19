package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "key_word")
public class KeyWord {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "key_words", nullable = false)
    private String key_words;
    @Column(name = "product_id", nullable = false, length = 80)
    private String product_id;
    @ManyToOne
    @JoinColumn(name = "product",nullable = false)
    private Product product;
}

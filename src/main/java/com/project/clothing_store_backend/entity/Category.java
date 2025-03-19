package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "category")
public class Category {
    @Id
    @Column(name = "property_id", nullable = false)
    private String property_id;

    @Column(name = "category_name", nullable = false, length = 255)
    private String category_name;
}

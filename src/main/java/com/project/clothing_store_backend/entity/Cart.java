package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "cart")
public class Cart {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "user_id", nullable = false, length = 80)
    private String user_id;
    @OneToOne(mappedBy = "cart",fetch = FetchType.LAZY)
    private ApplicationUser user;
    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
}

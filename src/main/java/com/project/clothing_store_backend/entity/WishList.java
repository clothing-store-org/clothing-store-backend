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
@Entity(name = "wish_list")
public class WishList {
    @Id
    @Column(name = "property_id", nullable = false, unique = true)
    private String property_id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private ApplicationUser user;

    @OneToMany(mappedBy = "wishList",fetch = FetchType.LAZY)
    private List<WishListItem> wishListItems;
}

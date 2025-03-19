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
@Entity(name = "wish_list")
public class WishList {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "user_id", nullable = false, length = 80)
    private String user_id;
    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private ApplicationUser user;
    @OneToMany(mappedBy = "wish-list",fetch = FetchType.LAZY)
    private List<WishListItem> wishListItems;
}

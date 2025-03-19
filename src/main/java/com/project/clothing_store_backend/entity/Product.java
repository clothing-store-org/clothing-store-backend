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
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "property_id", nullable = false,unique = true)
    private String propertyId;

    @Column(name = "product_title", nullable = false, length = 255)
    private String productTitle;

    @Column(name = "product_description", nullable = false, length = 255)
    private String productDescription;

    @Column(name = "unit_price", nullable = false,scale = 2)
    private double unitPrice;

    @Column(name = "qty_on_hand", nullable = false)
    private int qtyOnHand;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

//    new

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<KeyWord> keyWords;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductHasDiscount> productHasDiscounts;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<WishListItem> wishListItems;

}

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
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String property_id;
    @Column(name = "product_title", nullable = false, length = 255)
    private String product_title;
    @Column(name = "product_description", nullable = false, length = 255)
    private String product_description;
    @Column(name = "unit_price", nullable = false)
    private double unit_price;
    @Column(name = "qty_on_hand", nullable = false, length = 80)
    private int qty_on_hand;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @Column(name = "brand_id", nullable = false, length = 80)
    private String brand_id;
    @Column(name = "discount_id", nullable = false, length = 80)
    private String discount_id;
    @ManyToOne
    @JoinColumn(name = "brand",nullable = false)
    private Brand brand;
    @OneToOne
    @JoinColumn(name = "cartItem",nullable = false)
    private CartItem cartItem;
    @ManyToOne
    @JoinColumn(name = "discount",nullable = false)
    private Discount discount;
    @OneToMany(mappedBy = "Product",fetch = FetchType.LAZY)
    private List<Item> items;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<KeyWord> keyWords;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Review> reviews;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<WishListItem> wishListItems;
}

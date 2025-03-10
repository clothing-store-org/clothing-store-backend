package com.project.clothing_store_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "application_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUser {
    @Id
    @Column(name = "user_id", length = 80)
    private String userId;
    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name = "base_country", length = 100)
    private String baseCountry;
    @Column(name = "contact", length = 100)
    private String contact;
    @Column(name = "otp", length = 6)
    private String otp;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dob", nullable = false, columnDefinition = "DATETIME")
    private Date dob;
    @Column(name = "gender", length = 100)
    private String gender;
    @Column(name = "password", length = 750, nullable = false)
    private String password;
    @Column(name = "is_account_non_expired",columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked",columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired",columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private boolean isEnabled;
    @ManyToMany
    @JoinTable(name="user_user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> roles;
}

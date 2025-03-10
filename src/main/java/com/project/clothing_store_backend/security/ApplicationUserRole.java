package com.project.clothing_store_backend.security;
import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(
            ApplicationUserPermission.PRODUCT_READ,
            ApplicationUserPermission.PRODUCT_WRITE,
            ApplicationUserPermission.USER_ROLE_WRITE,
            ApplicationUserPermission.ORDER_WRITE,
            ApplicationUserPermission.ORDER_READ
    )),
    CUSTOMER(Sets.newHashSet(
            ApplicationUserPermission.PRODUCT_WRITE,
            ApplicationUserPermission.ORDER_WRITE,
            ApplicationUserPermission.ORDER_READ
    )),
    ADMIN_CONTROLLER(Sets.newHashSet(
            ApplicationUserPermission.PRODUCT_WRITE,
            ApplicationUserPermission.ORDER_WRITE,
            ApplicationUserPermission.ORDER_READ
    ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

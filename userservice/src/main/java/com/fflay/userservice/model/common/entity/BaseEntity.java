package com.fflay.userservice.model.common.entity;

import com.fflay.userservice.model.user.enums.TokenClaims;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Base entity class named {@link BaseEntity} with common fields for audit tracking and lifecycle management.
 * Provides automatic population of audit fields using JPA lifecycle annotations.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "updated_by")
    String updatedBy;

    /**
     * Sets the createdBy and createdAt fields before persisting the entity.
     * If no authenticated user is found, sets createdBy to "anonymousUser".
     */
    @PrePersist
    public void prePersist(){
        this.createdBy = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(user -> !"anonymousUser".equals(user))
                .map(Jwt.class::cast)
                .map(jwt -> jwt.getClaim(TokenClaims.USER_EMAIL.getValue()).toString())
                .orElse("anonymousUser");
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Sets the updatedBy and updatedAt fields before updating the entity.
     * If no authenticated user is found, sets updatedBy to "anonymousUser".
     */
    @PreUpdate
    public void preUpdate(){
        this.updatedBy = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(user -> !"anonymousUser".equals(user))
                .map(Jwt.class::cast)
                .map(jwt -> jwt.getClaim(TokenClaims.USER_EMAIL.getValue()).toString())
                .orElse("anonymousUser");
        this.updatedAt = LocalDateTime.now();
    }
}

package com.fflay.userservice.model.user.entity;

import com.fflay.userservice.model.common.entity.BaseEntity;
import com.fflay.userservice.model.user.enums.TokenClaims;
import com.fflay.userservice.model.user.enums.UserStatus;
import com.fflay.userservice.model.user.enums.UserType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a user entity named {@link UserEntity} in the system.
 * This entity stores user-related information such as email, password, and personal details.
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    String id;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name = "phone_number",
            length = 20
    )
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    UserType userType;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    UserStatus userStatus = UserStatus.ACTIVE;

    /**
     * Constructs a map of claims based on the user's attributes.
     * This map is typically used to create JWT claims for the user.
     * @return a map of claims containing user attributes
     */
    public Map<String, Object> getClaims(){
        final Map<String,Object> claims = new HashMap<>();
        claims.put(TokenClaims.USER_ID.getValue(), this.id);
        claims.put(TokenClaims.USER_TYPE.getValue(), this.userType);
        claims.put(TokenClaims.USER_STATUS.getValue(), this.userStatus);
        claims.put(TokenClaims.USER_FIRST_NAME.getValue(), this.firstName);
        claims.put(TokenClaims.USER_LAST_NAME.getValue(), this.lastName);
        claims.put(TokenClaims.USER_EMAIL.getValue(), this.email);
        claims.put(TokenClaims.USER_PHONE_NUMBER.getValue(), this.phoneNumber);
        return claims;
    }
}

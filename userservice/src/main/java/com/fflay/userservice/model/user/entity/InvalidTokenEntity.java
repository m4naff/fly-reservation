package com.fflay.userservice.model.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invalid_token")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvalidTokenEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "token_id")
    String tokenId;

}

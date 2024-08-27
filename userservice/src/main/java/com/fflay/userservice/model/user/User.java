package com.fflay.userservice.model.user;

import com.fflay.userservice.model.common.BaseDomainModel;
import com.fflay.userservice.model.user.enums.UserStatus;
import com.fflay.userservice.model.user.enums.UserType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Represents a user domain object named {@link User} in the system.
 * The {@code User} class is a domain model that contains user-related information such as
 * identification, contact details, status, type, and password. It extends {@link BaseDomainModel}
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseDomainModel {
    String id;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    UserStatus userStatus;
    UserType userType;
    String password;
}

package com.fflay.userservice.model.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Represents a request named {@link RegisterRequest} for user registration.
 * This class contains the necessary details required to register a new user.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    @Email(message = "Please enter valid e-mail address")
    @Size(min = 7,message = "Minimum e-mail length is 7 characters")
    String email;

    @Size(min = 8)
    String password;

    @NotBlank(message = "First name can't be blank.")
    String firstName;
    @NotBlank(message = "Last name can't be blank.")
    String lastName;

    @NotBlank(message = "Phone number can't be blank.")
    @Size(min = 11,max = 20)
    String phoneNumber;

    @NotBlank(message = "Role can't be blank.")
    String role;

}

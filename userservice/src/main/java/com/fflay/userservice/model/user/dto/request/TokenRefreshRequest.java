package com.fflay.userservice.model.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Represents a request named {@link TokenRefreshRequest} to refresh an access token using a refresh token.
 * This class contains the refresh token required for obtaining a new access token.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenRefreshRequest {
    @NotBlank
    private String token;

}

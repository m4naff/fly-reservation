package com.fflay.userservice.model.user.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Represents a response named {@link TokenResponse} containing tokens for authentication.
 * This class includes the access token, its expiration time, and the refresh token.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {
    private String accessToken;
    private Long accessTokenExpiresAt;
    private String refreshToken;
}

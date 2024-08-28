package com.fflay.userservice.model.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Represents a request named {@link TokenInvalidateRequest} to invalidate tokens.
 * This class contains the access and refresh tokens that need to be invalidated.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenInvalidateRequest {
    @NotBlank
    String accessToken;
    @NotBlank
    String refreshToken;
}

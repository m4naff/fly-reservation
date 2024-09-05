package com.fly.reservationservice.serializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Mixin class for {@link UsernamePasswordAuthenticationToken} to use custom deserialization.
 * This class is used to apply the custom {@link UsernamePasswordAuthenticationTokenDeserializer}
 * for deserializing JSON into a {@link UsernamePasswordAuthenticationToken} object.
 */
@JsonDeserialize(using = UsernamePasswordAuthenticationTokenDeserializer.class)
public class UsernamePasswordAuthenticationTokenMixin {
}

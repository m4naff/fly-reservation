package com.fly.reservationservice.serializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;

/**
 * Custom deserializer for {@link UsernamePasswordAuthenticationToken}.
 * This deserializer converts JSON into a {@link UsernamePasswordAuthenticationToken} object.
 */
public class UsernamePasswordAuthenticationTokenDeserializer extends JsonDeserializer<UsernamePasswordAuthenticationToken> {
    private final ObjectMapper objectMapper;

    public UsernamePasswordAuthenticationTokenDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule for date/time support
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); // ignore unknown properties
    }

    /**
     * Deserializes JSON into a {@link UsernamePasswordAuthenticationToken} object.
     * Extracts the principal, credentials, and authorities from the JSON.
     *
     * @param p the {@link JsonParser} used to parse the JSON
     * @param ctxt the {@link DeserializationContext} in which the deserialization occurs
     * @return a {@link UsernamePasswordAuthenticationToken} object
     * @throws IOException if an I/O error occurs
     * @throws JsonProcessingException if a JSON processing error occurs
     */
    @Override
    public UsernamePasswordAuthenticationToken deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        // Extract the nested principal object and deserialize it into a JwtRecord object
        JsonNode principalNode = node.get("principal");
        JwtRecord

    }
}

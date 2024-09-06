package com.fly.reservationservice.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fly.reservationservice.serializer.LocalDateTimeSerializer;
import com.fly.reservationservice.serializer.UsernamePasswordAuthenticationTokenMixin;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.time.LocalDateTime;

/**
 * Configuration class named {@link FeignClientConfig} for setting up Feign client components.
 * Configures custom error handling, object mapping, and decoding for Feign clients.
 */
@Slf4j
@Configuration
public class FeignClientConfig {

    /**
     * Provides a custom {@link ObjectMapper} bean configured with Jackson modules.
     *
     * @return a configured {@link ObjectMapper} instance
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(UsernamePasswordAuthenticationToken.class, UsernamePasswordAuthenticationTokenMixin.class);
        objectMapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        objectMapper.registerModule(module);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    /**
     * Provides a custom {@link Decoder} bean for Feign clients.
     *
     * @param objectMapper the {@link ObjectMapper} to use for decoding
     * @return a {@link Decoder} instance
     */
    @Bean
    public Decoder feignDecoder(ObjectMapper objectMapper){
        return new CustomDecoder(objectMapper);
    }

    /**
     * Provides a custom {@link ErrorDecoder} bean for Feign clients.
     *
     * @return a {@link ErrorDecoder} instance
     */
    @Bean
    public ErrorDecoder

}

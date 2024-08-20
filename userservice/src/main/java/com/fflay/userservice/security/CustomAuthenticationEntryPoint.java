package com.fflay.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fflay.userservice.model.common.CustomError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;

/**
 * Custom implementation of the {@link AuthenticationEntryPoint} interface.
 * This component is responsible for handling unauthorized access attempts
 * by sending a custom error response when authentication fails.
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        final CustomError customError = CustomError.builder()
                .header(CustomError.Header.AUTH_ERROR.getName())
                .httpStatus(HttpStatus.UNAUTHORIZED)
                .isSuccess(false)
                .build();

        final String responseBody = OBJECT_MAPPER
                .writer(DateFormat.getInstance())
                .writeValueAsString(customError);

        response.getOutputStream()
                .write(responseBody.getBytes());
    }
}

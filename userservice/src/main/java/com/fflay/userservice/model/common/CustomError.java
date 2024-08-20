package com.fflay.userservice.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * Represents a custom error response named {@link CustomError} structure for REST APIs.
 */
@Getter
@Builder
@FieldDefaults(level = PRIVATE)
public class CustomError {
    @Builder.Default
    LocalDateTime time = LocalDateTime.now();

    HttpStatus httpStatus;
    String header;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    @Builder.Default
    private Boolean isSuccess = false;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CustomSubError> subErrors;

    /**
     * Represents a sub-error with specific details as {@link CustomSubError}.
     */
    @Getter
    @Builder
    @FieldDefaults(level = PRIVATE)
    public static class CustomSubError{
        String message;
        String field;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Object value;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String type;
    }
    /**
     * Enumerates common error headers for categorizing errors as {@link Header}.
     */
    @Getter
    @RequiredArgsConstructor
    public enum Header{
        API_ERROR("API ERROR"),

        ALREADY_EXIST("ALREADY EXIST"),

        NOT_FOUND("NOT EXIST"),

        VALIDATION_ERROR("VALIDATION ERROR"),

        DATABASE_ERROR("DATABASE ERROR"),

        PROCESS_ERROR("PROCESS ERROR"),

        AUTH_ERROR("AUTH ERROR");
        private final String name;
    }
}

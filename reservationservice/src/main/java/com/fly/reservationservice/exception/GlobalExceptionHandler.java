package com.fly.reservationservice.exception;

import com.fly.reservationservice.model.common.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Global exception handler named {@link GlobalExceptionHandler}.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the {@link EntityAlreadyExistException} exception.
     *
     * @param e the exception
     * @return the response entity with the error message
     */
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<CustomError> handleEntityAlreadyExistException(EntityAlreadyExistException e) {
        CustomError error = CustomError.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .header(CustomError.Header.ALREADY_EXIST.getName())
                .isSuccess(false)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}

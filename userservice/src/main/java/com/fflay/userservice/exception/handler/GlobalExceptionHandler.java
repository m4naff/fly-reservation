package com.fflay.userservice.exception.handler;

import com.fflay.userservice.exception.TokenAlreadyInvalidatedException;
import com.fflay.userservice.exception.UserAlreadyExistException;
import com.fflay.userservice.model.common.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * Global exception handler named {@link GlobalExceptionHandler} for handling various types of exceptions in the application.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles TokenAlreadyInvalidatedException thrown when a token is already invalidated.
     *
     * @param ex The TokenAlreadyInvalidatedException instance.
     * @return ResponseEntity with CustomError containing details of the exception.
     */
    @ExceptionHandler(TokenAlreadyInvalidatedException.class)
    public ResponseEntity<Object> handleTokenAlreadyInvalidatedException(final TokenAlreadyInvalidatedException ex) {
        CustomError customError = CustomError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .header(CustomError.Header.API_ERROR.getName())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles UserAlreadyExistException thrown when a user already exists.
     *
     * @param ex The UserAlreadyExistException instance.
     * @return ResponseEntity with CustomError containing details of the exception.
     */
    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<CustomError> handleUserAlreadyExistException(final UserAlreadyExistException ex) {
        CustomError customError = CustomError.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .header(CustomError.Header.API_ERROR.getName())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(customError,HttpStatus.CONFLICT);
    }

}

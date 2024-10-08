package com.fflay.userservice.exception.handler;

import com.fflay.userservice.exception.*;
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

    /**
     * Handles UserNotFoundException thrown when a user is not found.
     *
     * @param ex The UserNotFoundException instance.
     * @return ResponseEntity with CustomError containing details of the exception.
     */
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<CustomError> handleUserNotFoundException(final UserNotFoundException ex) {
        CustomError customError = CustomError.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .header(CustomError.Header.API_ERROR.getName())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
    }

    /**
     * Handles PasswordNotValidException thrown when a password is not valid.
     *
     * @param ex The PasswordNotValidException instance.
     * @return ResponseEntity with CustomError containing details of the exception.
     */
    @ExceptionHandler(PasswordNotValidException.class)
    protected ResponseEntity<CustomError> handlePasswordNotValidException(final PasswordNotValidException ex) {
        CustomError customError = CustomError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .header(CustomError.Header.VALIDATION_ERROR.getName())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(customError,HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles UserStatusNotValidException thrown when a user status is not valid.
     *
     * @param ex The UserStatusNotValidException instance.
     * @return ResponseEntity with CustomError containing details of the exception.
     */
    @ExceptionHandler(UserStatusNotValidException.class)
    protected ResponseEntity<Object> handleUserStatusNotValidException(final UserStatusNotValidException ex) {
        CustomError customError = CustomError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .header(CustomError.Header.API_ERROR.getName())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

}

package com.fly.reservationservice.exception.handler;

import com.fly.reservationservice.exception.*;
import com.fly.reservationservice.model.common.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<CustomError> handleFlightNotFoundException(FlightNotFoundException e) {
        CustomError error = CustomError.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .isSuccess(false)
                .header(CustomError.Header.NOT_FOUND.getName())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SeatNumberNotFoundException.class)
    public ResponseEntity<CustomError> handleSeatNumberNotFoundException(SeatNumberNotFoundException e){
        CustomError error = CustomError.builder()
                .header(CustomError.Header.NOT_FOUND.getName())
                .message(e.getMessage())
                .isSuccess(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SeatAlreadyReservedException.class)
    public ResponseEntity<CustomError> handleSeatAlreadyReservedException(SeatAlreadyReservedException e){
        CustomError error = CustomError.builder()
                .header(CustomError.Header.ALREADY_EXIST.getName())
                .message(e.getMessage())
                .isSuccess(false)
                .httpStatus(HttpStatus.CONFLICT)
                .build();
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<CustomError> handleInsufficientFundsException(InsufficientFundsException e){
        CustomError error = CustomError.builder()
                .header(CustomError.Header.INSUFFICIENT_FUNDS.getName())
                .message(e.getMessage())
                .isSuccess(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}

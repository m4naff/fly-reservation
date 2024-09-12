package com.fly.reservationservice.exception;

/**
 * Exception thrown when a flight is not found.
 */
public class FlightNotFoundException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = """
            Flight not found!
        """;

    /**
     * Constructor for the exception with default message.
     */
    public FlightNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public FlightNotFoundException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }
}

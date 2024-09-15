package com.fly.reservationservice.exception;

/**
 * Exception thrown when there are insufficient funds.
 */
public class InsufficientFundsException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = """
        Insufficient funds!
        """;

    /**
     * Constructor for the exception with default message.
     */
    public InsufficientFundsException() {
        super(DEFAULT_MESSAGE);
    }

    public InsufficientFundsException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }

}

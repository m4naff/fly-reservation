package com.fly.reservationservice.exception;

/**
 * Exception thrown when an entity already exists.
 */
public class EntityAlreadyExistException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = """
        Entity already exists!
        """;

    /**
     * Constructor for the exception with default message.
     */
    public EntityAlreadyExistException() {
        super(DEFAULT_MESSAGE);
    }

    public EntityAlreadyExistException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }
}

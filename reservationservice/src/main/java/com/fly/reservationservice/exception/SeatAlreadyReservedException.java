package com.fly.reservationservice.exception;

public class SeatAlreadyReservedException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = """
        Seat already reserved!
        """;

    public SeatAlreadyReservedException() {
        super(DEFAULT_MESSAGE);
    }

    public SeatAlreadyReservedException(final String message) {
        super(DEFAULT_MESSAGE + " " + message);
    }
}

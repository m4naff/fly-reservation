package com.fly.reservationservice.service;

import com.fly.reservationservice.model.reservation.Seat;

import java.util.List;

/**
 * Service class for seat operations.
 */
public interface SeatService {

    /**
     * Get the available seats for a flight.
     * @param flightId the flight id
     * @return the available seats
     */
    List<Seat> availableSeats(String flightId);
}

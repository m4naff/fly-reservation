package com.fly.reservationservice.service;

/**
 * Service class to delete a flight.
 */
public interface FlightDeleteService {

    /**
     * Deletes a flight by its flight number.
     *
     * @param flightNumber the flight number
     */
    void deleteFlight(String flightNumber);
}

package com.fly.reservationservice.service;

import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;

/**
 * Service interface for flight operations.
 */
public interface FlightCreateService {

    /**
     * Create a new flight.
     *
     * @param flightCreateRequest the flight to create
     * @return the created flight
     */
    Flight createFlight(final FlightCreateRequest flightCreateRequest);

}

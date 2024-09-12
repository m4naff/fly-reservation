package com.fly.reservationservice.service.impl;

import com.fly.reservationservice.exception.FlightNotFoundException;
import com.fly.reservationservice.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class to delete a flight.
 */
@Service
@RequiredArgsConstructor
public class FlightDeleteServiceImpl {
   private final FlightRepository flightRepository;

        /**
        * Deletes a flight by its flight number.
        *
        * @param flightNumber the flight number
        */
        public void deleteFlight(String flightNumber) {
            var flightToBeDeleted = flightRepository.findByFlightNumber(flightNumber)
                    .orElseThrow(() -> new FlightNotFoundException("Flight with flight number " + flightNumber + " not found"));
            flightRepository.delete(flightToBeDeleted);
        }
}

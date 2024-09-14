package com.fly.reservationservice.service.impl;

import com.fly.reservationservice.exception.FlightNotFoundException;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.service.FlightDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class to delete a flight.
 */
@Service
@RequiredArgsConstructor
public class FlightDeleteServiceImpl implements FlightDeleteService {
   private final FlightRepository flightRepository;

        /**
        * Deletes a flight by its flight number.
        *
        * @param flightNumber the flight number
        */
        @Override
        public void deleteFlight(String flightNumber) {
            var flightToBeDeleted = flightRepository.findByFlightNumber(flightNumber)
                    .orElseThrow(() -> new FlightNotFoundException("Flight with flight number " + flightNumber + " not found"));
            flightRepository.delete(flightToBeDeleted);
        }
}

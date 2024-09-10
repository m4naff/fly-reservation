package com.fly.reservationservice.service.impl;

import com.fly.reservationservice.exception.EntityAlreadyExistException;
import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import com.fly.reservationservice.model.reservation.mapper.FlightCreateRequestToFlightEntityMapper;
import com.fly.reservationservice.model.reservation.mapper.FlightEntityToFlightMapper;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.service.FlightCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation named {@link FlightCreateServiceImpl} for flight operations.
 */
@Service
@RequiredArgsConstructor
public class FlightCreateServiceImpl implements FlightCreateService {
    private final FlightRepository flightRepository;
    private final FlightCreateRequestToFlightEntityMapper flightCreateRequestToFlightEntityMapper =
            FlightCreateRequestToFlightEntityMapper.initialize();
    private final FlightEntityToFlightMapper flightEntityToFlightMapper =
            FlightEntityToFlightMapper.initialize();

    /**
     * Creates a new flight.
     * Needs to have ADMIN role
     *
     * @param flightCreateRequest the flight to create
     * @return the created flight
     */
    @Override
    public Flight createFlight(FlightCreateRequest flightCreateRequest) {
        FlightEntity flightEntityToBeSaved = flightCreateRequestToFlightEntityMapper.map(flightCreateRequest);
        flightRepository.save(flightEntityToBeSaved);
        return flightEntityToFlightMapper.map(flightEntityToBeSaved);
    }
}

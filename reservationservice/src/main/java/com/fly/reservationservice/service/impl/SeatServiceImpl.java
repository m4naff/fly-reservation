package com.fly.reservationservice.service.impl;

import com.fly.reservationservice.exception.FlightNotFoundException;
import com.fly.reservationservice.model.reservation.Seat;
import com.fly.reservationservice.model.reservation.mapper.SeatEntityToSeatMapper;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.repository.SeatRepository;
import com.fly.reservationservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{
    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;
    private final SeatEntityToSeatMapper seatEntityToSeatMapper = SeatEntityToSeatMapper.initialize();

    /**
     * Get the available seats for a flight.
     * @param flightNumber the flight id
     * @return the available seats
     */
    @Override
    public List<Seat> availableSeats(String flightNumber) {
        var flight = flightRepository.findByFlightNumber(flightNumber).orElseThrow(
                () -> new FlightNotFoundException("Flight with number " + flightNumber + " not found.")
        );
        var seats = seatRepository.findSeatEntitiesByFlightEntity(flight);
        return seatEntityToSeatMapper.map(seats);
    }

}

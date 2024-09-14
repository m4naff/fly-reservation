package com.fly.reservationservice.service.impl;


import com.fly.reservationservice.exception.FlightNotFoundException;
import com.fly.reservationservice.exception.SeatNumberNotFoundException;
import com.fly.reservationservice.model.reservation.Ticket;
import com.fly.reservationservice.model.reservation.dto.request.TicketRequest;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.repository.SeatRepository;
import com.fly.reservationservice.service.BuyTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for buying tickets.
 */
@Service
@RequiredArgsConstructor
public class BuyTicketServiceImpl implements BuyTicketService {
    private final FlightRepository flightRepository;
    private final SeatRepository seatRepository;

    @Override
    public Ticket buyTicket(TicketRequest ticketRequest) {
        var flight = flightRepository.findByFlightNumber(ticketRequest.getFlightNumber()).orElseThrow(
                () -> new FlightNotFoundException("Flight with number " + ticketRequest.getFlightNumber() + " not found.")
        );
        var seat = seatRepository.findSeatEntityByFlightEntityAndSeatNumber(
                flight, ticketRequest.getSeatNumber()).orElseThrow(
                () -> new SeatNumberNotFoundException("Seat with number " + ticketRequest.getSeatNumber() + " not found.")
        );
        if (seat.isReserved()) {
            throw new SeatAlreadyReservedException("Seat with number " + ticketRequest.getSeatNumber() + " is already reserved.");
        }

    }
}

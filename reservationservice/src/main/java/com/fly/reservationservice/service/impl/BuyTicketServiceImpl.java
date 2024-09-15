package com.fly.reservationservice.service.impl;


import com.fly.reservationservice.exception.FlightNotFoundException;
import com.fly.reservationservice.exception.InsufficientFundsException;
import com.fly.reservationservice.exception.SeatAlreadyReservedException;
import com.fly.reservationservice.exception.SeatNumberNotFoundException;
import com.fly.reservationservice.model.reservation.Ticket;
import com.fly.reservationservice.model.reservation.dto.request.TicketRequest;
import com.fly.reservationservice.model.reservation.enums.TicketStatus;
import com.fly.reservationservice.model.reservation.mapper.TicketRequestToTicketEntityMapper;
import com.fly.reservationservice.model.reservation.mapper.TicketRequestToTicketMapper;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.repository.SeatRepository;
import com.fly.reservationservice.repository.TicketRepository;
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
    private final TicketRepository ticketRepository;
    private final TicketRequestToTicketMapper ticketRequestToTicketMapper = TicketRequestToTicketMapper.initialize();
    private final TicketRequestToTicketEntityMapper ticketRequestToTicketEntityMapper = TicketRequestToTicketEntityMapper.initialize();

    @Override
    public Ticket buyTicket(TicketRequest ticketRequest) {
        var flight = flightRepository.findByFlightNumber(ticketRequest.getFlightNumber()).orElseThrow(
                () -> new FlightNotFoundException("Flight with number " + ticketRequest.getFlightNumber() + " not found.")
        );
        var seat = seatRepository.findSeatEntityByFlightEntityAndSeatNumber(
                flight, ticketRequest.getSeatNumber()).orElseThrow(
                () -> new SeatNumberNotFoundException("Seat with number " + ticketRequest.getSeatNumber() + " not found.")
        );
        if (seat.getIsReserved()) {
            throw new SeatAlreadyReservedException("Seat with number " + ticketRequest.getSeatNumber() + " is already reserved.");
        }
        if(ticketRequest.getPrice().compareTo(flight.getPrice()) >= 0){
            seat.setIsReserved(true);
            seatRepository.save(seat);
            ticketRepository.save(ticketRequestToTicketEntityMapper.map(ticketRequest));
            return ticketRequestToTicketMapper.map(ticketRequest);
        }
        throw new InsufficientFundsException("Insufficient funds to buy ticket.");
    }
}

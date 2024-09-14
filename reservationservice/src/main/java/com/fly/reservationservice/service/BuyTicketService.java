package com.fly.reservationservice.service;

/**
 * Service interface named{@link BuyTicketService} for buying tickets.
 */
public interface BuyTicketService {

    /**
     * Buys a ticket for the given user.
     * @param ticketRequest the ticket request containing the user and ticket details
     * @return the ticket that was bought
     */
     Ticket buyTicket(TicketRequest ticketRequest);
}

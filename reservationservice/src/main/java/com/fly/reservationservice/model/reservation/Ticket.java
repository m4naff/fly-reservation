package com.fly.reservationservice.model.reservation;

import com.fly.reservationservice.model.reservation.enums.TicketStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a ticket for response.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    String flightNumber;
    String seatNumber;
    TicketStatus ticketStatus;
    BigDecimal price;
}

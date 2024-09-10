package com.fly.reservationservice.model.reservation.entity;

import com.fly.reservationservice.model.reservation.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tickets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "flight_number")
    String flightNumber;

    @Column(name = "user_id")
    String userId;

    @Column(name = "price")
    BigDecimal price;

    @Builder.Default
    @Column(name = "ticket_status")
    TicketStatus ticketStatus = TicketStatus.APPROVED;

    @Column(name = "seat_number")
    String seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    FlightEntity flight;
}

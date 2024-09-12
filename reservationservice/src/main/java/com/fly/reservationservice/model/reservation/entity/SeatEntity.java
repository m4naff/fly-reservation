package com.fly.reservationservice.model.reservation.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Entity class name {@link SeatEntity} used in {@link FlightEntity} to represent a seat in a flight
 * This entity stores seat-related information such as seat number and reservation status.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "seats")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "seat_number")
    String seatNumber;

    @Builder.Default
    @Column(name = "is_reserved")
    Boolean isReserved = false;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    FlightEntity flightEntity;





}

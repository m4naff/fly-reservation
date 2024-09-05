package com.fly.reservationservice.model.reservation.entity;


import com.fly.reservationservice.model.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a flight entity named {@link FlightEntity} in the system.
 * This entity stores flight-related information such as flight number, departure and arrival locations, and departure and arrival dates.
 * Has a relation with {@link SeatEntity} to store seat information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "flights")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    String id;

    @Column(name = "flight_number", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "flight_sequence", allocationSize = 1)
    Long flightNumber;

    @Column(name = "departure_date")
    LocalDateTime departureDate;

    @Column(name = "arrival_date")
    LocalDateTime arrivalDate;

    @Column(name = "departure_location")
    String departureLocation;

    @Column(name = "arrival_location")
    String arrivalLocation;

    @Column(name = "price")
    BigDecimal price;

    @OneToMany(mappedBy = "flightEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    List<SeatEntity> seats = new ArrayList<>();

}

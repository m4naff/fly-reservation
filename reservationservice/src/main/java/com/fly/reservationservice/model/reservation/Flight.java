package com.fly.reservationservice.model.reservation;

import com.fly.reservationservice.model.common.BaseDomainModel;
import com.fly.reservationservice.model.reservation.entity.SeatEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a flight.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flight extends BaseDomainModel {
    Long flightNumber;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    String departureLocation;
    String arrivalLocation;
    BigDecimal price;
    List<SeatEntity> seats;
}

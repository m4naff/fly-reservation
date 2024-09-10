package com.fly.reservationservice.model.reservation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO representing a flight request for creating a new Flight.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightCreateRequest {
    @NotBlank(message = "FlightNumber is required")
    Long flightNumber;
    @NotBlank(message = "DepartureDate is required")
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    @NotBlank(message = "DepartureLocation is required")
    String departureLocation;
    @NotBlank(message = "ArrivalLocation is required")
    String arrivalLocation;
    @Size(min = 0, message = "Price should be greater than 0")
    BigDecimal price;
}

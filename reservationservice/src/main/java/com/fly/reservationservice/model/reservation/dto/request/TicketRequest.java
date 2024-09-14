package com.fly.reservationservice.model.reservation.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

/**
 * Represents a ticket request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketRequest {
    @NotBlank(message = "FlightNumber is required")
    String flightNumber;
    @NotBlank(message = "SeatNumber is required")
    String seatNumber;
    @Min(value = 0, message = "Price should be greater than 0")
    BigDecimal price;
}

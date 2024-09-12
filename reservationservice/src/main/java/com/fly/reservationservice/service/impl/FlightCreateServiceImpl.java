package com.fly.reservationservice.service.impl;

import com.fly.reservationservice.exception.EntityAlreadyExistException;
import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import com.fly.reservationservice.model.reservation.entity.SeatEntity;
import com.fly.reservationservice.model.reservation.mapper.FlightCreateRequestToFlightEntityMapper;
import com.fly.reservationservice.model.reservation.mapper.FlightEntityToFlightMapper;
import com.fly.reservationservice.repository.FlightRepository;
import com.fly.reservationservice.service.FlightCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation named {@link FlightCreateServiceImpl} for flight operations.
 */
@Service
@RequiredArgsConstructor
public class FlightCreateServiceImpl implements FlightCreateService {
    private final FlightRepository flightRepository;
    private final FlightCreateRequestToFlightEntityMapper flightCreateRequestToFlightEntityMapper =
            FlightCreateRequestToFlightEntityMapper.initialize();
    private final FlightEntityToFlightMapper flightEntityToFlightMapper =
            FlightEntityToFlightMapper.initialize();

    /**
     * Creates a new flight.
     * Needs to have ADMIN role
     *
     * @param flightCreateRequest the flight to create
     * @return the created flight
     */
    @Override
    public Flight createFlight(FlightCreateRequest flightCreateRequest) {
        FlightEntity flightEntityToBeSaved = flightCreateRequestToFlightEntityMapper.map(flightCreateRequest);
        generateSeatsForFlight(flightEntityToBeSaved, 4,10);
        flightRepository.save(flightEntityToBeSaved);
        return flightEntityToFlightMapper.map(flightEntityToBeSaved);
    }

    /**
     * Generates seats for the given FlightEntity in a row and column format and associates them with the flight.
     *
     * @param flightEntity The flight entity for which seats will be generated.
     * @param numRows The number of rows to generate.
     * @param numColumns The number of columns per row.
     */
    private void generateSeatsForFlight(FlightEntity flightEntity, int numRows, int numColumns) {
        List<SeatEntity> seatEntities = new ArrayList<>();

        // Loop through each row (e.g., A, B, C...) and column (e.g., 1, 2, 3...)
        for (char row = 'A'; row < 'A' + numRows; row++) {
            for (int column = 1; column <= numColumns; column++) {
                // Create seat number in the format "A1", "A2", "B1", etc.
                String seatNumber = row + String.valueOf(column);

                // Create a seat entity and associate it with the flight
                SeatEntity seat = SeatEntity.builder()
                        .seatNumber(seatNumber) // e.g., A1, B3, C5
                        .isReserved(false)      // Default: not reserved
                        .flightEntity(flightEntity) // Associate seat with flight
                        .build();
                seatEntities.add(seat);
            }
        }

        // Assign generated seats to the flight entity
        flightEntity.setSeats(seatEntities);
    }
}

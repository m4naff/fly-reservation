package com.fly.reservationservice.repository;

import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import com.fly.reservationservice.model.reservation.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for seat operations.
 */
public interface SeatRepository extends JpaRepository<SeatEntity,String> {

    /**
     * Find seat entities by flight entity.
     * @param flightId the flight id
     * @return the seat entities
     */
    List<SeatEntity> findSeatEntitiesByFlightEntity(FlightEntity flightId);

    /**
     * Find seat entity by flight entity and seat number and is reserved.
     * @param flightEntity the flight entity
     * @param seatNumber the seat number
     * @return the seat entity
     */
    Optional<SeatEntity> findSeatEntityByFlightEntityAndSeatNumber(FlightEntity flightEntity, String seatNumber);
}

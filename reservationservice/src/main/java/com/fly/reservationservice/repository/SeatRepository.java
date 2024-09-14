package com.fly.reservationservice.repository;

import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import com.fly.reservationservice.model.reservation.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for seat operations.
 */
public interface SeatRepository extends JpaRepository<SeatEntity,String> {

    /**
     * Find seat entities by flight entity.
     * @param flightId the flight id
     * @return the seat entities
     */
    List<SeatEntity> findSeatEntitiesByFlightEntity(FlightEntity flightEntity);
}

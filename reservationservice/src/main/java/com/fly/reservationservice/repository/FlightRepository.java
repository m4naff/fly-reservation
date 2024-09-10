package com.fly.reservationservice.repository;

import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for {@link FlightEntity} to perform CRUD operations.
 */
public interface FlightRepository extends JpaRepository<FlightEntity, String> {

    /**
     * Find a flight by its flight number.
     *
     * @param flightNumber the flight number
     * @return the flight entity
     */
    Optional<FlightEntity> findByFlightNumber(Long flightNumber);
}

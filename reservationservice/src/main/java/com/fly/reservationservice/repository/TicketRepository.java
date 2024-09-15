package com.fly.reservationservice.repository;

import com.fly.reservationservice.model.reservation.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for ticket entity.
 */
public interface TicketRepository extends JpaRepository<TicketEntity,String> {
}

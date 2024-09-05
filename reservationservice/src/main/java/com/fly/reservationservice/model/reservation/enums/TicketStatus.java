package com.fly.reservationservice.model.reservation.enums;

/**
 * Enum representing various ticket statuses.
 */
public enum TicketStatus {
    PENDING,    // Ticket is created but awaiting user ID approval
    APPROVED,   // Admin has approved the ticket and user ID
    REJECTED,   // Admin has rejected the ticket and user ID
    CANCELLED,  // Ticket was canceled by the user or admin
    BOOKED,     // Ticket is fully booked and confirmed
    COMPLETED   // Flight is completed and ticket used
}
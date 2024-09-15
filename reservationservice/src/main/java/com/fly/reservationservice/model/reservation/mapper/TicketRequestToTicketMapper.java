package com.fly.reservationservice.model.reservation.mapper;

import com.fly.reservationservice.model.common.mapper.BaseMapper;
import com.fly.reservationservice.model.reservation.Ticket;
import com.fly.reservationservice.model.reservation.dto.request.TicketRequest;
import com.fly.reservationservice.model.reservation.enums.TicketStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketRequestToTicketMapper extends BaseMapper<TicketRequest, Ticket> {
    @Override
    default Ticket map(TicketRequest source){
        return Ticket.builder()
                .flightNumber(source.getFlightNumber())
                .seatNumber(source.getSeatNumber())
                .price(source.getPrice())
                .ticketStatus(TicketStatus.APPROVED)
                .build();
    }

    static TicketRequestToTicketMapper initialize(){
        return Mappers.getMapper(TicketRequestToTicketMapper.class);
    }
}

package com.fly.reservationservice.model.reservation.mapper;

import com.fly.reservationservice.model.common.mapper.BaseMapper;
import com.fly.reservationservice.model.reservation.dto.request.TicketRequest;
import com.fly.reservationservice.model.reservation.entity.TicketEntity;
import com.fly.reservationservice.model.reservation.enums.TicketStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper class to map {@link TicketRequest} to {@link TicketEntity}.
 */
@Mapper
public interface TicketRequestToTicketEntityMapper extends BaseMapper<TicketRequest, TicketEntity> {

    /**
     * Maps entity named {@link TicketRequest} to request named {@link TicketEntity}.
     *
     * @param source the collection of source objects to map
     * @return the {@link TicketEntity} of mapped target objects
     */
    @Override
    default TicketEntity map(TicketRequest source){
        return TicketEntity.builder()
                .flightNumber(source.getFlightNumber())
                .seatNumber(source.getSeatNumber())
                .price(source.getPrice())
                .ticketStatus(TicketStatus.APPROVED)
                .build();
    }

    static TicketRequestToTicketEntityMapper initialize(){
        return Mappers.getMapper(TicketRequestToTicketEntityMapper.class);
    }
}

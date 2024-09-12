package com.fly.reservationservice.model.reservation.mapper;

import com.fly.reservationservice.model.common.mapper.BaseMapper;
import com.fly.reservationservice.model.reservation.Seat;
import com.fly.reservationservice.model.reservation.entity.SeatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper class to map {@link SeatEntity} to {@link Seat}.
 */
@Mapper
public interface SeatEntityToSeatMapper extends BaseMapper<SeatEntity, Seat> {

    /**
     * Maps entity named {@link SeatEntity} to request named {@link Seat}.
     *
     * @param source the collection of source objects to map
     * @return the {@link Seat} of mapped target objects
     */
    @Override
    default Seat map(SeatEntity source){
        return Seat.builder()
                .seatNumber(source.getSeatNumber())
                .isReserved(source.getIsReserved())
                .build();
    }
    static SeatEntityToSeatMapper initialize(){
        return Mappers.getMapper(SeatEntityToSeatMapper.class);
    }
}

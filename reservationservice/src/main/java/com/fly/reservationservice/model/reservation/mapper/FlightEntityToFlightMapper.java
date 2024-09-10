package com.fly.reservationservice.model.reservation.mapper;

import com.fly.reservationservice.model.common.mapper.BaseMapper;
import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for mapping {@link FlightEntity} to {@link Flight}.
 */
@Mapper
public interface FlightEntityToFlightMapper extends BaseMapper<FlightEntity, Flight> {

    /**
     * Maps entity named {@link FlightEntity} to request named {@link Flight}.
     *
     * @param source the collection of source objects to map
     * @return the {@link Flight} of mapped target objects
     */
    @Override
    default Flight map(FlightEntity source){
        return Flight.builder()
                .flightNumber(source.getFlightNumber())
                .departureDate(source.getDepartureDate())
                .arrivalDate(source.getArrivalDate())
                .departureLocation(source.getDepartureLocation())
                .arrivalLocation(source.getArrivalLocation())
                .price(source.getPrice())
                .build();
    }

    /**
     * Initializes and returns an instance of FlightEntityToFlightMapper.
     *
     * @return Initialized FlightEntityToFlightMapper instance.
     */
    static FlightEntityToFlightMapper initialize(){
        return Mappers.getMapper(FlightEntityToFlightMapper.class);
    }
}

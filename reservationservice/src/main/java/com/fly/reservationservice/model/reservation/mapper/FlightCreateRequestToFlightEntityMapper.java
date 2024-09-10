package com.fly.reservationservice.model.reservation.mapper;

import com.fly.reservationservice.model.common.mapper.BaseMapper;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.model.reservation.entity.FlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightCreateRequestToFlightEntityMapper extends BaseMapper<FlightCreateRequest,FlightEntity> {

    /**
     * Maps request name {@link FlightCreateRequest} to entity named {@link FlightEntity}.
     *
     * @param source the collection of source objects to map
     * @return the {@link FlightEntity} of mapped target objects
     */
    @Override
    default FlightEntity map(FlightCreateRequest source) {
        return FlightEntity.builder()
                .flightNumber(source.getFlightNumber())
                .departureDate(source.getDepartureDate())
                .arrivalDate(source.getArrivalDate())
                .departureLocation(source.getDepartureLocation())
                .arrivalLocation(source.getArrivalLocation())
                .price(source.getPrice())
                .build();
    }

    /**
     * Initializes and returns an instance of FlightCreateRequestToFlightEntityMapper.
     *
     * @return Initialized FlightCreateRequestToFlightEntityMapper instance.
     */
    static FlightCreateRequestToFlightEntityMapper initialize(){
        return Mappers.getMapper(FlightCreateRequestToFlightEntityMapper.class);
    }

}

package com.fly.reservationservice.controller;

import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.service.FlightCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for flight operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flight")
public class FlightController {
   private final FlightCreateService flightCreateService;

    @GetMapping("/create-flight")
    public ResponseEntity<Flight> createFlight(@RequestBody FlightCreateRequest flightCreateRequest){
        return new ResponseEntity<>(flightCreateService.createFlight(flightCreateRequest), HttpStatus.CREATED);
    }


}

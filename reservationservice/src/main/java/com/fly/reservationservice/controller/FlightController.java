package com.fly.reservationservice.controller;

import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.service.FlightCreateService;
import com.fly.reservationservice.service.FlightDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for flight operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flight")
public class FlightController {
   private final FlightCreateService flightCreateService;
   private final FlightDeleteService flightDeleteService;

    @PostMapping("/create-flight")
    public ResponseEntity<Flight> createFlight(@RequestBody FlightCreateRequest flightCreateRequest){
        return new ResponseEntity<>(flightCreateService.createFlight(flightCreateRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-flight/{flightNumber}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightNumber){
        flightDeleteService.deleteFlight(flightNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

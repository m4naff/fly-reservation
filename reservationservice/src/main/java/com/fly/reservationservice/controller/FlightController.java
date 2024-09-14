package com.fly.reservationservice.controller;

import com.fly.reservationservice.model.reservation.Flight;
import com.fly.reservationservice.model.reservation.Seat;
import com.fly.reservationservice.model.reservation.dto.request.FlightCreateRequest;
import com.fly.reservationservice.service.FlightCreateService;
import com.fly.reservationservice.service.FlightDeleteService;
import com.fly.reservationservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for flight operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flight/")
public class FlightController {
   private final FlightCreateService flightCreateService;
   private final FlightDeleteService flightDeleteService;
   private final SeatService seatService;

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

    @GetMapping("/seats/{flightId}")
    public ResponseEntity<List<Seat>> seats(@PathVariable String flightId){
        return new ResponseEntity<>(seatService.availableSeats(flightId), HttpStatus.OK);
    }


}

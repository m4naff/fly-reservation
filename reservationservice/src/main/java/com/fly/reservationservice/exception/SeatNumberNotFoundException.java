package com.fly.reservationservice.exception;

/**
 * Exception thrown when seat number is not found.
 */
public class SeatNumberNotFoundException extends RuntimeException{
   private static final String DEFAULT_MESSAGE = """
           Seat number not found!
           """ ;

   public SeatNumberNotFoundException(){
         super(DEFAULT_MESSAGE);
   }
   public SeatNumberNotFoundException(final String message){
         super(DEFAULT_MESSAGE + " " + message);
   }
}

package org.practice.springrest.tourist_management.touristmanagementapi.advice;

import org.practice.touristmanagementapi.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice // This makes it a Global Exception Handler
public class GlobalExceptionHandler {

    // Handles your custom TouristNotFoundException
    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), "Check the ID provided", LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handles any other unexpected exceptions (Generic)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {
        ErrorDetails error = new ErrorDetails("An internal server error occurred", ex.getMessage(), LocalTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

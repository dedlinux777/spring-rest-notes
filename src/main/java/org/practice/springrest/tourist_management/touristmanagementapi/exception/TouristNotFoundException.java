package org.practice.springrest.tourist_management.touristmanagementapi.exception;

public class TouristNotFoundException extends RuntimeException {

    public TouristNotFoundException(String message) {
        super(message);
    }
}

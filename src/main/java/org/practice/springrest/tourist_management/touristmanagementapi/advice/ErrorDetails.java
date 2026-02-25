package org.practice.springrest.tourist_management.touristmanagementapi.advice;

import java.time.LocalTime;

public class ErrorDetails {
    private String message;
    private String details;
    private LocalTime time;

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", time=" + time +
                '}';
    }

    public ErrorDetails() {
    }

    public ErrorDetails(String message, String details, LocalTime time) {
        this.message = message;
        this.details = details;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}

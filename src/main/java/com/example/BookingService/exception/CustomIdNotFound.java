package com.example.BookingService.exception;

import java.util.List;

public class CustomIdNotFound  extends RuntimeException{
    List<String> details;

    public CustomIdNotFound(String message) {
        super(message);
    }

    public CustomIdNotFound(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}

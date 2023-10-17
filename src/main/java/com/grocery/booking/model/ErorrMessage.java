package com.grocery.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErorrMessage {
    private final String status="ERROR";
    HttpStatus httpStatus;
    String message;
}


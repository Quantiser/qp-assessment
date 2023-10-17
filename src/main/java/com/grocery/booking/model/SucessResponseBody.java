package com.grocery.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucessResponseBody {
    private final String status="SUCCESS";
    private String message;
    private Object data;
}

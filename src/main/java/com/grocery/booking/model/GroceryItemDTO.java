package com.grocery.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryItemDTO {

    private  Long id;
    private  String name;
    private String description;
    private Double price;
    private int quantity;


}

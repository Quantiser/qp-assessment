package com.grocery.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryItem {

    @Id
    private long itemId;
    private int quantity;
    private String itemName;
    private double price;




}

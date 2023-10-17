package com.grocery.booking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderItemId;


    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    private long groceryItem;

    private int quantity;

}

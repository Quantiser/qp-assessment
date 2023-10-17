package com.grocery.booking.service;

import com.grocery.booking.entity.GroceryItem;

public interface GroceryQuantityManager {

    void reduceQuantity(Long id, int quantity);
}

package com.grocery.booking.service;

import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.exception.NotEnoughQuantityException;
import com.grocery.booking.model.GroceryItemDTO;
import com.grocery.booking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryQuantityManagerImpl implements GroceryQuantityManager{

    @Autowired
    GroceryItemRepository groceryItemRepository;


    @Override
    public void reduceQuantity(Long id, int quantity) {
        GroceryItem groceryItem = groceryItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ITEM_NOT_FOUN"));
        if(groceryItem.getQuantity()<quantity) throw new NotEnoughQuantityException("NOT_ENOUGH_QUANTITY");
        groceryItem.setQuantity(groceryItem.getQuantity()-quantity);
        groceryItemRepository.save(groceryItem);
    }
}

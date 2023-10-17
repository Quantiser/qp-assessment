package com.grocery.booking.service;

import com.grocery.booking.model.GroceryItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroceryItemService {

    void addItem(GroceryItemDTO groceryItemDTO);
    GroceryItemDTO updateItem(Long id,GroceryItemDTO groceryItemDTO);
    Long deleteItem(Long itemId);
    GroceryItemDTO getItemById(Long id);

    List<GroceryItemDTO> getAllAvailableItems();
}

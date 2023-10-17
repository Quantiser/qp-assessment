package com.grocery.booking.service;

import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.exception.ItemNotFoundException;
import com.grocery.booking.model.GroceryItemDTO;
import com.grocery.booking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrocerItemServiceImpl implements GroceryItemService{


    @Autowired
    GroceryItemRepository groceryItemRepository;

    @Override
    public void addItem(GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem =GroceryItem.builder()
                .itemId(groceryItemDTO.getId())
                .itemName(groceryItemDTO.getName())
                .price(groceryItemDTO.getPrice())
                .quantity(groceryItemDTO.getQuantity())
                .build();

        groceryItemRepository.save(groceryItem);
    }

    @Override
    public GroceryItemDTO updateItem(Long id, GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = groceryItemRepository.findById(id)
                .orElseThrow(()-> new ItemNotFoundException("ITEM_NOT_FOUND"));
        groceryItem.setPrice(groceryItemDTO.getPrice());
        groceryItem.setItemName(groceryItem.getItemName());
        groceryItem.setQuantity(groceryItem.getQuantity());

        groceryItemRepository.save(groceryItem);

        return groceryItemDTO;
    }

    @Override
    public Long deleteItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
        return itemId;
    }

    @Override
    public GroceryItemDTO getItemById(Long id) {
        GroceryItem groceryItem= groceryItemRepository.findById(id)
                .orElseThrow(()-> new ItemNotFoundException("ITEM_NOT_FOUND"));
        GroceryItemDTO groceryItemDTO = GroceryItemDTO
                .builder()
                .price(groceryItem.getPrice())
                .quantity(groceryItem.getQuantity())
                .id(groceryItem.getItemId())
                .name(groceryItem.getItemName())
                .build();
        return groceryItemDTO;
    }

    @Override
    public List<GroceryItemDTO> getAllAvailableItems() {
        List<GroceryItem> items = groceryItemRepository.findAll();
        List<GroceryItemDTO> groceryItemDTOS = new ArrayList<>();
        for (GroceryItem groceryItem : items) {

            if (groceryItem.getQuantity() > 0) {
                // Convert the GroceryItem entity to GroceryItemDTO
                GroceryItemDTO groceryItemDTO = new GroceryItemDTO();
                groceryItemDTO.setId(groceryItem.getItemId());
                groceryItemDTO.setName(groceryItem.getItemName());
                groceryItemDTO.setPrice(groceryItem.getPrice());
                groceryItemDTO.setQuantity(groceryItem.getQuantity());
                groceryItemDTOS.add(groceryItemDTO);
            }
        }

        return groceryItemDTOS;
    }

}

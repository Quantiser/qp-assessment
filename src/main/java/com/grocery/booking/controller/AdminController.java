package com.grocery.booking.controller;


import com.grocery.booking.model.GroceryItemDTO;
import com.grocery.booking.model.OrderDTO;
import com.grocery.booking.model.SucessResponseBody;
import com.grocery.booking.service.GroceryItemService;
import com.grocery.booking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    OrderService orderService;



    @PostMapping("addItem")
    public ResponseEntity<SucessResponseBody> addGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO){
        groceryItemService.addItem(groceryItemDTO);


        return ResponseEntity.status(HttpStatus.CREATED).body(new SucessResponseBody("Item Successfully added",groceryItemDTO));
    }


    @PutMapping("updateItem/{id}")
    public ResponseEntity<SucessResponseBody> updateItem(@RequestBody GroceryItemDTO groceryItemDTO, @PathVariable Long id){

        GroceryItemDTO groceryItemDTO1 = groceryItemService.updateItem(id,groceryItemDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new SucessResponseBody("Item updated",groceryItemDTO1));
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<SucessResponseBody> deleteGroceryItem(@PathVariable Long id){

        Long deletedItemid = groceryItemService.deleteItem(id);

        return  ResponseEntity.status(HttpStatus.OK).body(new SucessResponseBody("Item Deleted","Item Id: "+id));
    }

    @GetMapping("getItem/{id}")
    public ResponseEntity<SucessResponseBody> getGroceryById(@PathVariable Long id){
        GroceryItemDTO groceryItemDTO = groceryItemService.getItemById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new SucessResponseBody("Retrieved Item Details",groceryItemDTO));
    }

    @GetMapping("getAllItems")
    public ResponseEntity<SucessResponseBody> getAllItemsDetails(){
        List<GroceryItemDTO> groceryItemDTOS = groceryItemService.getAllAvailableItems();

        return ResponseEntity.status(HttpStatus.OK).body(new SucessResponseBody("Retrieved Item Details",groceryItemDTOS));
    }
}

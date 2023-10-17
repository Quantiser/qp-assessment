package com.grocery.booking.controller;

import com.grocery.booking.entity.User;
import com.grocery.booking.model.*;
import com.grocery.booking.service.GroceryItemService;
import com.grocery.booking.service.OrderService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    OrderService orderService;

    @GetMapping("/getAllItems")
    public ResponseEntity<SucessResponseBody> getAllAvailableItems(){
        List<GroceryItemDTO> groceryItemDTOS = groceryItemService.getAllAvailableItems();

        return ResponseEntity.status(HttpStatus.OK).body(new SucessResponseBody("All Available items retried",groceryItemDTOS));

    }

    @PostMapping("bookOrder")
    public ResponseEntity<SucessResponseBody> bookOrder(@RequestBody OrderRequest orderRequest){
        Long orderId = orderService.bookOrder(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new SucessResponseBody("Order Booked with Id: "+orderId, orderId));
    }

    @PostMapping("addUser")
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){

        orderService.adduser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

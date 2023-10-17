package com.grocery.booking.service;


import com.grocery.booking.entity.Order;
import com.grocery.booking.entity.OrderItem;
import com.grocery.booking.entity.User;
import com.grocery.booking.exception.UserFoundNotExecption;
import com.grocery.booking.model.*;
import com.grocery.booking.repository.GroceryItemRepository;
import com.grocery.booking.repository.OrderItemRepository;
import com.grocery.booking.repository.OrderRepository;
import com.grocery.booking.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GroceryQuantityManager groceryQuantityManager;

    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    GroceryItemRepository groceryItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public Long bookOrder(OrderRequest orderRequest) {
        log.info("Order Request: "+orderRequest );
        User user = userRepository.findById(orderRequest.getUserId()).orElseThrow(() -> new UserFoundNotExecption("USER_NOT_FOUND"));

        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());

        double totalAmount=0;
        for(OrderItemDTO orderItemDto: orderRequest.getItems()){
            OrderItem orderItem = OrderItem
                    .builder()
                    .groceryItem(orderItemDto.getGroceryItemId())
                    .quantity(orderItemDto.getQuantity())
                    .order(order)
                    .build();
            orderItems.add(orderItem);
            GroceryItemDTO groceryItem= groceryItemService.getItemById(orderItemDto.getGroceryItemId());
            groceryQuantityManager.reduceQuantity(groceryItem.getId(),orderItem.getQuantity());
            totalAmount+= orderItem.getQuantity()*(groceryItem.getPrice());
        }

        order.setOrderItemList(orderItems);
        order.setTotalAmount(totalAmount);
        Order placedOrder= orderRepository.save(order);

        return placedOrder.getOrderId();
    }


    /*
        Temporary method to add user.
     */
    @Override
    public void adduser(UserDTO userDTO) {
        User user = User
                .builder()
                .userId(userDTO.getId())
                .userName(userDTO.getUserName())
                .password("temp")
                .role("ADMIN")
                .build();
        userRepository.save(user);
    }
}

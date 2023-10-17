package com.grocery.booking.service;


import com.grocery.booking.model.OrderRequest;
import com.grocery.booking.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Long bookOrder(OrderRequest orderRequest);

    void adduser(UserDTO userDTO);
}

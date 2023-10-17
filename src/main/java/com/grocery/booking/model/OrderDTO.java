package com.grocery.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long userId;
    private Double totalQuantity;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
}

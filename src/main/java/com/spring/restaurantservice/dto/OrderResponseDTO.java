package com.spring.restaurantservice.dto;

import java.util.Date;

public record OrderResponseDTO(String orderId, String name, int qty, double price, Date orderDate, String status, int estimateDeliveryWindow) {
}

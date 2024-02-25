package com.spring.restaurantservice.dao;

import com.spring.restaurantservice.dto.OrderResponseDTO;
import com.spring.restaurantservice.exception.OrderByNameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class RestaurantOrderDAO {
    public OrderResponseDTO getOrders(String orderId) {
        return generateRandomOrders().get(orderId);
    }

    private Map<String, OrderResponseDTO> generateRandomOrders() {
        Map<String, OrderResponseDTO> orderMap = new HashMap<>();
        orderMap.put("78sdfs89", new OrderResponseDTO("78sdfs89", "VEG-MEALS", 1, 199, new Date(), "READY", 15));
        orderMap.put("12jkli89", new OrderResponseDTO("12jkli89", "HYDRABADI DUM BIRYANI", 2, 641, new Date(), "PREPARING", 15));
        orderMap.put("98hjku84", new OrderResponseDTO("98hjku84", "PANEER TIKKA MASALA", 1, 250, new Date(), "DELIVERED", 15));
        return orderMap;
    }

    public OrderResponseDTO getOrderByName(String orderName) {
        return generateRandomOrders().entrySet()
                .stream()
                .filter(dto -> orderName.equalsIgnoreCase(dto.getValue().name()))
                .findAny()
                .orElseThrow(() -> new OrderByNameNotFoundException("Order not available with name :" + orderName))
                .getValue();
    }
}

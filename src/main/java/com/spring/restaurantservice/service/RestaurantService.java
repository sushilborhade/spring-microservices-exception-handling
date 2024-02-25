package com.spring.restaurantservice.service;

import com.spring.restaurantservice.dao.RestaurantOrderDAO;
import com.spring.restaurantservice.dto.OrderResponseDTO;
import com.spring.restaurantservice.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantOrderDAO orderDAO;
    public String greeting() {
        return "Welcome to Swigggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        OrderResponseDTO orderResponseDTO = orderDAO.getOrders(orderId);
        if(orderResponseDTO != null){
            return orderResponseDTO;
        }else{
            throw new OrderNotFoundException("Order not available with id :" + orderId);
        }
    }

    public OrderResponseDTO getOrderByName(String orderName) {
        return orderDAO.getOrderByName(orderName);
//        if(orderResponseDTO != null){
//            return orderResponseDTO;
//        }else{
//            throw new OrderNotFoundException("Order not available with name :" + orderName);
//        }
    }
}

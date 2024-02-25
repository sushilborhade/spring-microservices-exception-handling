package com.spring.restaurantservice.controller;

import com.spring.restaurantservice.dto.OrderResponseDTO;
import com.spring.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public String greetingMessage(){
        return service.greeting();
    }

    @GetMapping("/orders/status/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId){
        return service.getOrder(orderId);
    }
    @GetMapping("/orders/name/{orderName}")
    public OrderResponseDTO getOrderByName(@PathVariable String orderName){
        return service.getOrderByName(orderName);
    }
}

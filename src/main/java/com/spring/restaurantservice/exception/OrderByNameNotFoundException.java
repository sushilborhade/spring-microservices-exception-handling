package com.spring.restaurantservice.exception;

public class OrderByNameNotFoundException extends RuntimeException{

    public OrderByNameNotFoundException(String message) {
        super(message);
    }
}
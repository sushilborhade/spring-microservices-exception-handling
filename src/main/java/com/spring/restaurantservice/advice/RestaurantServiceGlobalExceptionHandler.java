package com.spring.restaurantservice.advice;

import com.spring.restaurantservice.dto.CustomErrorResponse;
import com.spring.restaurantservice.dto.GlobalErrorCode;
import com.spring.restaurantservice.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class RestaurantServiceGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOrderNotFoundException(Exception exception) {
        CustomErrorResponse errorResponse = new CustomErrorResponse.Builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_ORDER_NOT_FOUND)
                .errorMessage(exception.getMessage())
                .build();
        System.out.println("RestaurantServiceGlobalExceptionHandler.handleOrderNotFoundException exception caught " + exception.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(OrderNotFoundException exception) {
        CustomErrorResponse errorResponse = new CustomErrorResponse.Builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_ORDER_NOT_FOUND)
                .errorMessage(exception.getMessage())
                .build();
        System.out.println("RestaurantServiceGlobalExceptionHandler.handleOrderNotFoundException exception caught " + exception.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
//    @ExceptionHandler(OrderByNameNotFoundException.class)
//    public ResponseEntity<?> handleOrderByNameNotFoundException(OrderByNameNotFoundException exception) {
//        CustomErrorResponse errorResponse = new CustomErrorResponse.Builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .errorCode(GlobalErrorCode.ERROR_ORDER_NOT_FOUND)
//                .errorMessage(exception.getMessage())
//                .build();
//        System.out.println("RestaurantServiceGlobalExceptionHandler.handleOrderByNameNotFoundException exception caught " + exception.getMessage());
//        return ResponseEntity.internalServerError().body(errorResponse);
//    }
}

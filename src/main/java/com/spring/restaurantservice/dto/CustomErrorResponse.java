package com.spring.restaurantservice.dto;

import org.springframework.http.HttpStatus;

public record CustomErrorResponse(HttpStatus status, String errorMessage, String errorCode) {
    public static final class Builder{
        private HttpStatus status;
        private String errorMessage;
        private String errorCode;
        public Builder status(HttpStatus status){
            this.status = status;
            return this;
        }
        public Builder errorMessage(String errorMessage){
            this.errorMessage = errorMessage;
            return this;
        }
        public Builder errorCode(String errorCode){
            this.errorCode = errorCode;
            return this;
        }

        public CustomErrorResponse build(){
            return new CustomErrorResponse(status, errorMessage, errorCode);
        }
    }
}

package com.example.wallet_service.exception;

public class NotEnoughBalanceException extends RuntimeException{
    private String message;

    public NotEnoughBalanceException() {}

    public NotEnoughBalanceException(String message) {
        super(message);
        this.message = message;
    }
}

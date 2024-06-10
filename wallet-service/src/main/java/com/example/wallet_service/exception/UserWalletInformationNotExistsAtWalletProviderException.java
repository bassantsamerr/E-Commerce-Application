package com.example.wallet_service.exception;

public class UserWalletInformationNotExistsAtWalletProviderException extends RuntimeException{
    private String message;

    public UserWalletInformationNotExistsAtWalletProviderException() {}

    public UserWalletInformationNotExistsAtWalletProviderException(String message) {
        super(message);
        this.message = message;
    }
}

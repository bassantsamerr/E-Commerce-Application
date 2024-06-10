package com.example.wallet_service.controller;

import com.example.wallet_service.entity.Transaction;
import com.example.wallet_service.exception.ErrorResponse;
import com.example.wallet_service.exception.NotEnoughBalanceException;
import com.example.wallet_service.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transaction")
@RestController
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;
    public TransactionController(){}
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }
    @ExceptionHandler(value = NotEnoughBalanceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleNotEnoughBalanceException(NotEnoughBalanceException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

}

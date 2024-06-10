package com.example.wallet_service.service;

import com.example.wallet_service.entity.Transaction;
import com.example.wallet_service.entity.Walletprovider;
import com.example.wallet_service.exception.NotEnoughBalanceException;
import com.example.wallet_service.repository.TransactionRepository;
import com.example.wallet_service.repository.UserRepository;
import com.example.wallet_service.repository.WalletProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletServiceImpl walletServiceImpl;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletProviderRepository walletProviderRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Long userID = walletServiceImpl.getUserIDOfWalletID(transaction.getWalletId());
        Long walletID = walletServiceImpl.getWalletIDOfWalletID(transaction.getWalletId());

        Walletprovider walletprovider = walletProviderRepository.findById(walletID.intValue())
                .orElseThrow(() -> new RuntimeException("Walletprovider not found with ID: " + walletID));

        if (transaction.getTransactionType() == Transaction.TransactionType.DEPOSIT) {  // Assuming TransactionType is an enum
            walletprovider.setBalance(walletprovider.getBalance() + transaction.getAmount().doubleValue());
        } else if (transaction.getTransactionType() == Transaction.TransactionType.WITHDRAWAL) {
            if(transaction.getAmount().doubleValue() > walletprovider.getBalance()){
                throw new NotEnoughBalanceException("Not enough balance, payment is rejected");
            }
            walletprovider.setBalance(walletprovider.getBalance() - transaction.getAmount().doubleValue());
        }

        walletProviderRepository.save(walletprovider);  // Save the updated wallet provider
        transactionRepository.save(transaction);        // Save the transaction

        return transaction;
    }

}

package com.example.wallet_service.entity;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "wallet_id", nullable = false)
    private Long walletId;


    @NotNull
    @Column(name="amount")
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="transactionType")
    private TransactionType transactionType;

    // Enum for transaction type
    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

    // Constructors
    public Transaction() {
    }

    public Transaction(Long wallet_id, BigDecimal amount, TransactionType transactionType) {
        this.walletId = wallet_id;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", wallet=" + walletId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }
}

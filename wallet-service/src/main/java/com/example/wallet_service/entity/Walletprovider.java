package com.example.wallet_service.entity;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "wallet_provider")
public class Walletprovider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "mobile_number")
    private String mobileNumber;

    @NotNull
    @Column(name = "national_id")
    private String nationalID;

    @NotNull
    @Column(name = "balance")
    private double balance;

    public Walletprovider() {
    }

    public Walletprovider(String mobileNumber, String nationalID, double balance) {
        this.mobileNumber = mobileNumber;
        this.nationalID = nationalID;
        this.balance = balance;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobile_number) {
        this.mobileNumber = mobile_number;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String national_id) {
        this.nationalID = national_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Walletprovider{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", balance=" + balance +
                '}';
    }
}

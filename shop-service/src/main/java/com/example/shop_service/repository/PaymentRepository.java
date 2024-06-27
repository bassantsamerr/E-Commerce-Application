package com.example.shop_service.repository;

import com.example.shop_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}

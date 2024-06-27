package com.example.shop_service.repository;

import com.example.shop_service.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}

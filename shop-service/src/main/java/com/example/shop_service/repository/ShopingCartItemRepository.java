package com.example.shop_service.repository;

import com.example.shop_service.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopingCartItemRepository extends JpaRepository<ShoppingCartItem,Integer> {
}

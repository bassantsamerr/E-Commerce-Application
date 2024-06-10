package com.example.wallet_service.repository;

import com.example.wallet_service.entity.Walletprovider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletProviderRepository extends JpaRepository<Walletprovider,Integer> {
}

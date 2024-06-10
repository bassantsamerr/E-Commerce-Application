package com.example.wallet_service.service;

import com.example.wallet_service.entity.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WalletServiceImpl implements WalletService{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long getUserIDOfWalletID(long id) {
        TypedQuery<Wallet> query = em.createQuery(
                "SELECT w FROM Wallet w WHERE w.id = :id", Wallet.class);
        query.setParameter("id", id);

        Wallet wallet = query.getSingleResult();
        return wallet.getUserId();
    }

    @Override
    public Long getWalletIDOfWalletID(long id) {
        TypedQuery<Wallet> query = em.createQuery(
                "SELECT w FROM Wallet w WHERE w.id = :id", Wallet.class);
        query.setParameter("id", id);

        Wallet wallet = query.getSingleResult();
        return wallet.getWalletId();
    }
}

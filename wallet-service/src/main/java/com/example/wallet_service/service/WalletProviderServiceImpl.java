package com.example.wallet_service.service;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Service
public class WalletProviderServiceImpl implements WalletProviderService {

    @PersistenceContext
    private EntityManager em;
    public Integer checkWalletExist(String mobileNumber, String nationalID) {
        TypedQuery<Integer> queryForMobileNumberAndNationalID = em.createQuery(
                "SELECT w.id FROM Walletprovider w WHERE w.mobileNumber = :mobileNumber AND w.nationalID = :nationalID", Integer.class);

        queryForMobileNumberAndNationalID.setParameter("mobileNumber", mobileNumber);
        queryForMobileNumberAndNationalID.setParameter("nationalID", nationalID);

        List<Integer> ids = queryForMobileNumberAndNationalID.getResultList();
        if (!ids.isEmpty()) {
            return ids.get(0); // Return the ID of the first row found
        }
        return null; // Return null if no matching row is found
    }


}

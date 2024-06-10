package com.example.wallet_service.service;

import com.example.wallet_service.entity.User;
import com.example.wallet_service.entity.Wallet;
import com.example.wallet_service.exception.UserAlreadyExistsException;
import com.example.wallet_service.exception.UserWalletInformationNotExistsAtWalletProviderException;
import com.example.wallet_service.repository.UserRepository;
import com.example.wallet_service.repository.WalletRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    WalletProviderServiceImpl walletProviderServiceImpl;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;
    public UserServiceImpl() {
    }
    public UserServiceImpl(WalletProviderServiceImpl walletProviderServiceImpl) {
        this.walletProviderServiceImpl = walletProviderServiceImpl;
    }
    @PersistenceContext
    private EntityManager em;
    @Override
    public boolean checkUserExist(User user) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.mobileNumber = :mobileNumber " +
                        "AND u.nationalID = :nationalID AND u.username = :username AND u.email = :email", Long.class);
        query.setParameter("mobileNumber", user.getMobileNumber());
        query.setParameter("nationalID", user.getNationalID());
        query.setParameter("username", user.getUsername());
        query.setParameter("email", user.getEmail());

        long count = query.getSingleResult();
        return count > 0;
    }
    @Override
    public User  SignUp(User user) {
        Integer walletID=walletProviderServiceImpl.checkWalletExist(user.getMobileNumber(),user.getNationalID());
        if(walletID==null)
            throw new UserWalletInformationNotExistsAtWalletProviderException("Your wallet information is not correct");
        if(checkUserExist(user))
            throw new UserAlreadyExistsException("User is already exists");
        userRepository.save(user);
        System.out.println("user.getId()"+user.getId()+"walletID.longValue()"+walletID.longValue());
        Wallet wallet=new Wallet(user.getId(),walletID.longValue());
        walletRepository.save(wallet);
        return user;

    }
}

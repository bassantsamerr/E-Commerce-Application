package com.example.wallet_service.repository;

import com.example.wallet_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
public interface UserRepository extends JpaRepository<User,Long> {
}

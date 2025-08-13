package com.example.uscoding.repository;

import com.example.uscoding.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, BigInteger> {
    Optional<UserAccount> findByEmail(String email);
}
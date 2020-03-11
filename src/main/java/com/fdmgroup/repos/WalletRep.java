package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Wallet;

public interface WalletRep extends JpaRepository<Wallet, Integer>{

}

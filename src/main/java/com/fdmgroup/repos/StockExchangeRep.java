package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.StockExchange;

public interface StockExchangeRep extends JpaRepository<StockExchange, Integer> {

}

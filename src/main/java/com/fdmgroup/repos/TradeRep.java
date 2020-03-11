package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Trade;



public interface TradeRep extends JpaRepository<Trade, Integer> {

}

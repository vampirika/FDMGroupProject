package com.fdmgroup.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Currency;

public interface CurrencyRep extends JpaRepository<Currency, Integer> {

}

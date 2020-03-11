package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.SharePrice;

public interface SharePriceRep extends JpaRepository<SharePrice, Integer> {

}

package com.fdmgroup.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Shareholder;

public interface ShareholderRep extends JpaRepository<Shareholder, String> {



}

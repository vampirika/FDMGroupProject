package com.fdmgroup.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Broker;

public interface BrokerRep extends JpaRepository<Broker,String>{



}

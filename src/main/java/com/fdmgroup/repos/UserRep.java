package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.User;



public interface UserRep extends JpaRepository<User, Integer>{

}

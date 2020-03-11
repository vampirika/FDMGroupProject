package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.BasicUser;



public interface BasicUserRep extends JpaRepository<BasicUser,String>{

}

package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.UserRequest;

public interface UserRequestRep extends JpaRepository<UserRequest, String> {

}

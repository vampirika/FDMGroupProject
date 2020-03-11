package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Share;

public interface ShareRep extends JpaRepository<Share, Integer> {

}

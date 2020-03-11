package com.fdmgroup.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Sysadmin;



public interface SysAdminRep extends JpaRepository<Sysadmin, String>{



}

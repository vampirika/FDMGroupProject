package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Company;

public interface CompanyRep extends JpaRepository<Company, Integer> {

}

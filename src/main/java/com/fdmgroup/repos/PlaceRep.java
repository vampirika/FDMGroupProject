package com.fdmgroup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.entities.Place;

public interface PlaceRep extends JpaRepository<Place, Integer> {

}

package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="places")
public class Place {
	@Id
	@Column (name = "place_id", length = 10)
	@GeneratedValue 
	private int placeId;
	@Column (length = 20)
	private String city;
	@Column (length = 30)
	private String country;
	
	
	
	
	public Place() {
		
	}
	
	
	public Place(int placeId, String city, String country) {
		super();
		this.placeId = placeId;
		this.city = city;
		this.country = country;
	}

	
	
	
	public int getPlaceId() {
		return placeId;
	}


	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + placeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (placeId != other.placeId)
			return false;
		return true;
	}


	
	
	
	
	
	
}

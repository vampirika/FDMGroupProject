package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="users")
@Inheritance(
	    strategy = InheritanceType.JOINED
)
public  class User {

	@Id
	@Column(name="user_id")
	protected int userId;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String country;
	
	
	
	
	protected User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected User(int userId, String name, String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.country = country;
	}
	
	
	
	protected int getUserId() {
		return userId;
	}
	protected void setUserId(int userId) {
		this.userId = userId;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getCountry() {
		return country;
	}
	protected void setCountry(String country) {
		this.country = country;
	}
	
	
	
}

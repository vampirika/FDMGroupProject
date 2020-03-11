package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="sysadmin")
@PrimaryKeyJoinColumn(name = "username")
public class Sysadmin extends BasicUser {
	
	
	
	
	
	
	
	
	@Override
	public void initialising() {
		// TODO Auto-generated method stub
		super.initialising();
	}

	@Override
	public String pageRedirect() {
		
		return "ViewUserRequest";
	}

	public void listTrades() {
		
	}
	
	public void listUsers() {
		
	}
	
	public void setFee() {
		
	}
	
	public void updateFee() {
		
	}

	
	
	
}

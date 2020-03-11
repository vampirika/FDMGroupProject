package com.fdmgroup.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="brokers")
@PrimaryKeyJoinColumn(name = "username")
public class Broker extends BasicUser{
	
	
	
	@Override
	public void initialising() {
		// TODO Auto-generated method stub
		super.initialising();
	}

	@Override
	public String pageRedirect() {
		// TODO Auto-generated method stub
		return "broker";
	}

	protected void acceptRequest() {
		
	}
	
	protected void denyRequest() {
		
	}
	
	protected void updateFee() {
		
	}

	
	
	




}

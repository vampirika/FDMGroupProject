package com.fdmgroup.entities;

import com.fdmgroup.corona.UserType;

public class UserFactory {

	public UserFactory() {

	}

	public static BasicUser factory(UserType type) {
		
	    switch(type) {
	      case SYSTEMADMIN:
	    	  return new Sysadmin();
	      case SHAREHOLDER:
	    	  return new Shareholder();
	
	      case BROKER:
	    	  return new Broker();
	     
	    
	  }
		return null;
	}
}

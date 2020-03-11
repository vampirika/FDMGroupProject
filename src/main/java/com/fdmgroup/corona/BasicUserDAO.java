package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.BasicUser;
import com.fdmgroup.repos.BasicUserRep;
@Service
public class BasicUserDAO {
	@Autowired
	private BasicUserRep repp;

	private Optional<BasicUser> basicUsers;
	private List<BasicUser> allBasicUsers;

	public void addBasicUser(BasicUser basicUser) {
		basicUsers = repp.findById(basicUser.getUsername());
		if (!basicUsers.isPresent()) {

			repp.save(basicUser);
		}
	}

	public BasicUser getBasicUser(String basicUserId) {
		basicUsers = repp.findById(basicUserId);
		if (basicUsers.isPresent()) {

			return basicUsers.get();
		} else {
			System.out.print("No share price whith this id therefore is ");
			return null;
		}
	}

	public void removeBasicUser(String basicUserId) {
		basicUsers = repp.findById(basicUserId);

		if (basicUsers.isPresent()) {
			repp.delete(basicUsers.get());
			System.out.println("basicUser removed");
		} else {
			System.out.println("No share price under this id");
		}

	}

	public void updateBasicUser(BasicUser basicUser) {

		basicUsers = repp.findById(basicUser.getUsername());
		if (basicUsers.isPresent()) {
			repp.save(basicUser);
			System.out.println("share price changed");
		}
	}

	public List<BasicUser> listBasicUsers() {
		allBasicUsers = repp.findAll();

		return allBasicUsers;
	}

	public BasicUserDAO() {

	}

	
}

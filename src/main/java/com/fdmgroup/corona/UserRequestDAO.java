package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.UserRequest;
import com.fdmgroup.repos.UserRequestRep;
@Service
public class UserRequestDAO {
	@Autowired
	private UserRequestRep repp;

	private Optional<UserRequest> userRequests;
	private List<UserRequest> allUserRequests;

	public void addUserRequest(UserRequest userRequest) {
		userRequests = repp.findById(userRequest.getUserName());
		if (!userRequests.isPresent()) {

			repp.save(userRequest);
		}
	}

	public UserRequest getUserRequest(String userRequestId) {
		userRequests = repp.findById(userRequestId);
		if (userRequests.isPresent()) {

			return userRequests.get();
		} else {
			System.out.print("No userRequest whith this id therefore is ");
			return null;
		}
	}

	public void removeUserRequest(String userRequestId) {
		userRequests = repp.findById(userRequestId);

		if (userRequests.isPresent()) {
			repp.delete(userRequests.get());
			System.out.println("userRequest removed");
		} else {
			System.out.println("No userRequest under this id");
		}

	}

	public void updateUserRequest(UserRequest userRequest) {

		userRequests = repp.findById(userRequest.getUserName());
		if (userRequests.isPresent()) {
			repp.save(userRequest);
			System.out.println("userRequest changed");
		}
	}

	public List<UserRequest> listUserRequests() {
		allUserRequests = repp.findAll();

		return allUserRequests;
	}

	public UserRequestDAO() {

	}

	
}

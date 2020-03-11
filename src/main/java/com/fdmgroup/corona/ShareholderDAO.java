package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Shareholder;
import com.fdmgroup.repos.ShareholderRep;

@Service
public class ShareholderDAO {
	@Autowired
	private ShareholderRep repp;

	private Optional<Shareholder> shareholders;
	private List<Shareholder> allShareholders;

	public void addShareholder(Shareholder shareholder) {
		shareholders = repp.findById(shareholder.getUsername());
		if (!shareholders.isPresent()) {

			repp.save(shareholder);
		}
	}

	public Shareholder getShareholder(String shareholder) {
		shareholders = repp.findById(shareholder);
		if (shareholders.isPresent()) {

			return shareholders.get();
		} else {
			System.out.print("No shareholder whith this id therefore is ");
			return null;
		}
	}

	public void removeShareholder(String shareholder) {
		shareholders = repp.findById(shareholder);

		if (shareholders.isPresent()) {
			repp.delete(shareholders.get());
			System.out.println("shareholder removed");
		} else {
			System.out.println("No shareholder under this id");
		}

	}

	public void updateShareholder(Shareholder shareholder) {

		shareholders = repp.findById(shareholder.getUsername());
		if (shareholders.isPresent()) {
			repp.save(shareholder);
			System.out.println("shareholder changed");
		}
	}

	public List<Shareholder> listShareholders() {
		allShareholders = repp.findAll();

		return allShareholders;
	}

	public ShareholderDAO() {

	}

}

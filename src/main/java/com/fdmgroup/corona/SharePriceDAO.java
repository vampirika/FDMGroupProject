package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.SharePrice;
import com.fdmgroup.repos.SharePriceRep;
@Service
public class SharePriceDAO {
	
	@Autowired
	private SharePriceRep repp;

	private Optional<SharePrice> sharePrices;
	private List<SharePrice> allSharePrices;

	public void addSharePrice(SharePrice sharePrice) {
		sharePrices = repp.findById(sharePrice.getShareId());
		if (!sharePrices.isPresent()) {

			repp.save(sharePrice);
		}
	}

	public SharePrice getSharePrice(int sharePriceId) {
		sharePrices = repp.findById(sharePriceId);
		if (sharePrices.isPresent()) {

			return sharePrices.get();
		} else {
			System.out.print("No share price whith this id therefore is ");
			return null;
		}
	}

	public void removeSharePrice(int sharePriceId) {
		sharePrices = repp.findById(sharePriceId);

		if (sharePrices.isPresent()) {
			repp.delete(sharePrices.get());
			System.out.println("sharePrice removed");
		} else {
			System.out.println("No share price under this id");
		}

	}

	public void updateSharePrice(SharePrice sharePrice) {

		sharePrices = repp.findById(sharePrice.getShareId());
		if (sharePrices.isPresent()) {
			repp.save(sharePrice);
			System.out.println("share price changed");
		}
	}

	public List<SharePrice> listSharePrices() {
		allSharePrices = repp.findAll();

		return allSharePrices;
	}

	public SharePriceDAO() {

	}

	
}

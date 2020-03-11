package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Share;
import com.fdmgroup.repos.ShareRep;
@Service
public class ShareDAO {
	@Autowired
	private ShareRep repp;

	private Optional<Share> shares;
	private List<Share> allShares;

	public void addShare(Share share) {
		shares = repp.findById(share.getShareId());
		if (!shares.isPresent()) {

			repp.save(share);
		}
	}

	public Share getShare(int shareId) {
		shares = repp.findById(shareId);
		if (shares.isPresent()) {

			return shares.get();
		} else {
			System.out.print("No share whith this id therefore is ");
			return null;
		}
	}

	public void removeShare(int shareId) {
		shares = repp.findById(shareId);

		if (shares.isPresent()) {
			repp.delete(shares.get());
			System.out.println("share removed");
		} else {
			System.out.println("No share under this id");
		}

	}

	public void updateShare(Share share) {

		shares = repp.findById(share.getShareId());
		if (shares.isPresent()) {
			repp.save(share);
			System.out.println("share changed");
		}
	}

	public List<Share> listShares() {
		allShares = repp.findAll();

		return allShares;
	}

	public ShareDAO() {

	}

	
}

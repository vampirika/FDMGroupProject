package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Wallet;
import com.fdmgroup.repos.WalletRep;

@Service
public class WalletDAO {

	@Autowired
	private WalletRep repp;

	List<Wallet> allWallets;
	Optional<Wallet> wallets;

	public void addWallet(Wallet wallet) {
		wallets = repp.findById(wallet.getWalletId());
		if (!wallets.isPresent()) {

			repp.save(wallet);
		}
	}

	public Wallet getWallet(int walletId) {
		wallets = repp.findById(walletId);
		if (wallets.isPresent()) {

			return wallets.get();
		} else {
			System.out.print("No wallets whith this id therefore is ");
			return null;
		}
	}

	public void removeWallet(int walletId) {
		wallets = repp.findById(walletId);

		if (wallets.isPresent()) {
			repp.delete(wallets.get());
			System.out.println("wallet removed");
		} else {
			System.out.println("No wallets under this id");
		}

	}

	public void updateWallet(Wallet wallet) {

		wallets = repp.findById(wallet.getWalletId());
		if (wallets.isPresent()) {
			repp.save(wallet);
			System.out.println("basket changed");
		}
	}

	public List<Wallet> listWallets() {
		allWallets = repp.findAll();
		return allWallets;
	}

	public WalletDAO() {

	}
}

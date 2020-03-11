package com.fdmgroup.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.corona.WalletDAO;





@Entity(name="shareholders")
@PrimaryKeyJoinColumn(name = "username")
public class Shareholder extends BasicUser{
	
	@OneToOne
	@JoinColumn(name="wallet_id")
	private Wallet wallet;// Give shareholder a wallet
	@ElementCollection
	@CollectionTable(name="shareholer_shares",  // name of joining table
					joinColumns=@JoinColumn(name="username")) // pk of table relating to this class
	@MapKeyJoinColumn(name="share_id") // pk of class used as Map key
	@Column(name="quantity") // name of value column from Map
	// must create reference to Map interface - cannot reference concrete class
	private Map<Share,Integer> portfolio = new HashMap<Share,Integer>();


	
	@Override
	public void initialising() {
	}

	@Override
	public String pageRedirect() {
		
		return "Shareholder";
	}

	public Wallet getWallet() {
		return wallet;
	}

	public Map<Share, Integer> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Map<Share, Integer> portfolio) {
		this.portfolio = portfolio;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public void addShares(Share sh,int quantity) {
		portfolio.put(sh,quantity);	
	}
	
	public void removeShares(Share sh,int quantity) {
		portfolio.remove(sh);	
	}
	

	

	@Override
	public String toString() {
		return wallet + " " ;
	}

	public void requestTrade() {
		
		// In here goes code for sending a trade request
		// ... when we get there :)
		
	}


	
	
	
}

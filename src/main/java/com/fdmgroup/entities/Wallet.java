package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity(name = "Wallets")
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WALLET_SEQ")
	@SequenceGenerator(sequenceName = "wallet_seq", allocationSize = 1, name = "WALLET_SEQ")
	@Column(name = "wallet_id", length = 10)
	private  int walletId;
	@Column(name = "budget", precision = 10, scale = 2)
	private double budget;

	public Wallet(double budget) { //User user
		super();
		this.budget = budget;	
	}
	public Wallet() {
		super();
	}
//Hash Code and equals methods	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(budget);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + walletId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		if (Double.doubleToLongBits(budget) != Double.doubleToLongBits(other.budget))
			return false;
		if (walletId != other.walletId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return " " + budget;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	

	
}

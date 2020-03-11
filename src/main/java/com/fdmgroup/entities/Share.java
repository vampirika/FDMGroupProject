package com.fdmgroup.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "shares")
public class Share {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "share_id")
	private int shareId;
	@Column
	private double price;
	@Column
	private String currency;
	@OneToMany(mappedBy = "theShare")
	List<Trade> tradeList = new ArrayList<Trade>();

	@Column
	private String name;

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addTrade(Trade trade) {
		tradeList.add(trade);

	}

	@Override
	public String toString() {
		return "Share [shareId=" + shareId + ", price=" + price + ", currency=" + currency + ", tradeList=" + tradeList
				+ ", name=" + name + "]";
	}

}

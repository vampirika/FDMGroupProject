package com.fdmgroup.entities;


import javax.persistence.Column;
import javax.persistence.Id;


public class ShareRequest {

	@Id
	@Column(name = "share_req_id")
	private int shareReqId;

	@Column
	private double price;
	@Column
	private String currency;
	@Column
	private String name;
	@Column(name = "share_id")
	private int shareId;
	
	
	public ShareRequest() 
	{
	}

	public int getShareReqId() {
		return shareReqId;
	}


	public void setShareReqId(int shareReqId) {
		this.shareReqId = shareReqId;
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
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareReqId = shareId;
	}
	

}

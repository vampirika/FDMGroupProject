
package com.fdmgroup.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SharePrice {
//the id needs to be changed to composite primary key
	@Id
	@Column(name="share_price_id")
	private int sharePriceId;
	
	@Column(name="share_id")
	private int shareId;
	@Column
	private double price;
	@Column(name="time_start")
	private Date timeStart;
	@Column(name="time_end")
	private Date timeEnd;
	@Column
	private String currency;
	
	
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
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}

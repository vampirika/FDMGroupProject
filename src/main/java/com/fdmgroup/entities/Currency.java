package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	@Column(name="currency_id")
	private int currencyId;
	@Column
	private String symbol;
	@Column
	private String name;
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}

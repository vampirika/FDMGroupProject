package com.fdmgroup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "companies")
public class Company {
	@Id
	@Column(name = "company_id", length = 10)
	@GeneratedValue
	private int companyId;
	@Column(name = "company_name", length = 50)
	private String companyName;
	@Column(name = "currency", length = 50)
	private String currency;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Company(String companyName, String currency) {
		super();
		this.companyName = companyName;
		this.currency = currency;
	}
	
	
	public Company() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
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
		Company other = (Company) obj;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}

}

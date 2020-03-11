package com.fdmgroup.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "trades")
public class Trade {

@Id
@Column(name =  "trade_id")
@GeneratedValue(strategy = GenerationType.AUTO)
private int tradeId;

@ManyToOne
private Share theShare;

@ManyToOne
private StockExchange se;



@OneToMany
@Column(name =  "broker_id")
private List<Broker> brokerlist = new ArrayList<>();
@OneToMany
@Column(name =  "stock_ex_id")
private List<StockExchange> stockExList = new ArrayList<>();;


@Temporal(TemporalType.TIMESTAMP)
@Column(name =  "transaction_time")
private Date orderDate;	
@Column(name =  "share_ammount")
private int shareAmmount;
@Column(name =  "price_total")
private int priceTotal;
public int getTradeId() {
	return tradeId;
}
public void setTradeId(int tradeId) {
	this.tradeId = tradeId;
}



public Share getTheShare() {
	return theShare;
}
public void setTheShare(Share theShare) {
	this.theShare = theShare;
}
public List<Broker> getBrokerlist() {
	return brokerlist;
}
public void setBrokerlist(List<Broker> brokerlist) {
	this.brokerlist = brokerlist;
}
public List<StockExchange> getStockExList() {
	return stockExList;
}
public void setStockExList(List<StockExchange> stockExList) {
	this.stockExList = stockExList;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public int getShareAmmount() {
	return shareAmmount;
}
public void setShareAmmount(int shareAmmount) {
	this.shareAmmount = shareAmmount;
}
public int getPriceTotal() {
	return priceTotal;
}
public void setPriceTotal(int priceTotal) {
	this.priceTotal = priceTotal;
} 

public void addStockExchange(StockExchange se) {
	stockExList.add(se);
}

public void addBroker(Broker broker) {
	brokerlist.add(broker);
}


public StockExchange getSe() {
	return se;
}
public void setSe(StockExchange se) {
	this.se = se;
}

}

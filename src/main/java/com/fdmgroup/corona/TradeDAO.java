package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Trade;
import com.fdmgroup.repos.TradeRep;

@Service
public class TradeDAO {
	@Autowired
	private TradeRep repp;

	private Optional<Trade> trades;
	private List<Trade> allTrades;

	public void addTrade(Trade trade) {
		trades = repp.findById(trade.getTradeId());
		if (!trades.isPresent()) {

			repp.save(trade);
		}
	}

	public Trade getTrade(int tradeId) {
		trades = repp.findById(tradeId);
		if (trades.isPresent()) {

			return trades.get();
		} else {
			System.out.print("No trade whith this id therefore is ");
			return null;
		}
	}

	public void removeTrade(int tradeId) {
		trades = repp.findById(tradeId);

		if (trades.isPresent()) {
			repp.delete(trades.get());
			System.out.println("trade removed");
		} else {
			System.out.println("No trade under this id");
		}

	}

	public void updateTrade(Trade trade) {

		trades = repp.findById(trade.getTradeId());
		if (trades.isPresent()) {
			repp.save(trade);
			System.out.println("trade changed");
		}
	}

	public List<Trade> listTrades() {
		allTrades = repp.findAll();

		return allTrades;
	}

	public TradeDAO() {

	}

	
}

package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.StockExchange;
import com.fdmgroup.repos.StockExchangeRep;


@Service
public class StockExchangeDAO {

	@Autowired
	private StockExchangeRep repp;

	private Optional<StockExchange> stockExchanges;
	private List<StockExchange> allStockExchanges;

	public void addStockExchange(StockExchange stockExchange) {
		stockExchanges = repp.findById(stockExchange.getStockExId());
		if (!stockExchanges.isPresent()) {

			repp.save(stockExchange);
		}
	}

	public StockExchange getStockExchange(int stockExchangeId) {
		stockExchanges = repp.findById(stockExchangeId);
		if (stockExchanges.isPresent()) {

			return stockExchanges.get();
		} else {
			System.out.print("No stockExchange whith this id therefore is ");
			return null;
		}
	}

	public void removeStockExchange(int stockExchangeId) {
		stockExchanges = repp.findById(stockExchangeId);

		if (stockExchanges.isPresent()) {
			repp.delete(stockExchanges.get());
			System.out.println("stockExchange removed");
		} else {
			System.out.println("No stockExchange under this id");
		}

	}

	public void updateStockExchange(StockExchange stockExchange) {

		stockExchanges = repp.findById(stockExchange.getStockExId());
		if (stockExchanges.isPresent()) {
			repp.save(stockExchange);
			System.out.println("stockExchange changed");
		}
	}

	public List<StockExchange> listStockExchanges() {
		allStockExchanges = repp.findAll();

		return allStockExchanges;
	}

	public StockExchangeDAO() {

	}
	
}

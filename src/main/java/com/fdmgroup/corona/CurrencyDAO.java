package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Currency;
import com.fdmgroup.repos.CurrencyRep;

@Service
public class CurrencyDAO {
	@Autowired
	private CurrencyRep repp;

	private Optional<Currency> currencies;
	private List<Currency> allCurrencies;

	public void addCurrency(Currency currency) {
		currencies = repp.findById(currency.getCurrencyId());
		if (!currencies.isPresent()) {

			repp.save(currency);
		}
	}

	public Currency getCurrency(int currencyId) {
		currencies = repp.findById(currencyId);
		if (currencies.isPresent()) {

			return currencies.get();
		} else {
			System.out.print("No Currencys whith this id therefore is ");
			return null;
		}
	}

	public void removeCurrency(int currencyId) {
		currencies = repp.findById(currencyId);

		if (currencies.isPresent()) {
			repp.delete(currencies.get());
			System.out.println("Currency removed");
		} else {
			System.out.println("No Currencys under this id");
		}

	}

	public void updateCurrency(Currency currency) {

		currencies = repp.findById(currency.getCurrencyId());
		if (currencies.isPresent()) {
			repp.save(currency);
			System.out.println("Currency changed");
		}
	}

	public List<Currency> listCurrencies() {
		allCurrencies = repp.findAll();

		return allCurrencies;
	}

	public CurrencyDAO() {

	}

	
}

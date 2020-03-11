package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Broker;
import com.fdmgroup.repos.BrokerRep;


@Service
public class BrokerDAO {
	@Autowired
	private BrokerRep repp;

	private Optional<Broker> brokers;
	private List<Broker> allBrokers;

	public void addBroker(Broker broker) {
		brokers = repp.findById(broker.getUsername());
		if (!brokers.isPresent()) {

			repp.save(broker);
		}
	}

	public Broker getBroker(String brokerId) {
		brokers = repp.findById(brokerId);
		if (brokers.isPresent()) {

			return brokers.get();
		} else {
			System.out.print("No brokers whith this id therefore is ");
			return null;
		}
	}

	public void removeBroker(String brokerId) {
		brokers = repp.findById(brokerId);

		if (brokers.isPresent()) {
			repp.delete(brokers.get());
			System.out.println("broker removed");
		} else {
			System.out.println("No brokers under this id");
		}

	}

	public void updateBroker(Broker broker) {

		brokers = repp.findById(broker.getUsername());
		if (brokers.isPresent()) {
			repp.save(broker);
			System.out.println("broker changed");
		}
	}

	public List<Broker> listBrokers() {
		allBrokers = repp.findAll();

		return allBrokers;
	}

	public BrokerDAO() {

	}

	
}

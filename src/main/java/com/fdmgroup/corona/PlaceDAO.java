package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Place;
import com.fdmgroup.repos.PlaceRep;
@Service
public class PlaceDAO {
	@Autowired
	private PlaceRep repp;

	private Optional<Place> places;
	private List<Place> allPlaces;

	public void addPlace(Place place) {
		places = repp.findById(place.getPlaceId());
		if (!places.isPresent()) {

			repp.save(place);
		}
	}

	public Place getPlace(int placeId) {
		places = repp.findById(placeId);
		if (places.isPresent()) {

			return places.get();
		} else {
			System.out.print("No place whith this id therefore is ");
			return null;
		}
	}

	public void removePlace(int placeId) {
		places = repp.findById(placeId);

		if (places.isPresent()) {
			repp.delete(places.get());
			System.out.println("place removed");
		} else {
			System.out.println("No place under this id");
		}

	}

	public void updatePlace(Place place) {

		places = repp.findById(place.getPlaceId());
		if (places.isPresent()) {

			repp.save(place);
			System.out.println("place changed");
		}
	}

	public List<Place> listPlaces() {
		allPlaces = repp.findAll();

		return allPlaces;
	}

	public PlaceDAO() {

	}

	
}

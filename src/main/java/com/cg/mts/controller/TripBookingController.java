package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.service.ITripBookingService;
import com.cg.mts.service.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private ITripBookingService tripBookingService;

	@PostMapping("/add/tripbooking")
	public TripBooking add() {
		TripBooking tripBooking = new TripBooking();
		tripBooking = tripBookingService.insertTripBooking(tripBooking);
		return tripBooking;
	}
	
	@PutMapping("/update/tripbooking")
	public TripBooking update() {
		TripBooking tripBooking = new TripBooking();
		tripBooking = tripBookingService.updateTripBooking(tripBooking);
		return tripBooking;
	}

	@DeleteMapping("/delete/tripbooking")
	public void delete(TripBooking tripBooking) {
		tripBooking = tripBookingService.deleteTripBooking(tripBooking);
	}
	
	@GetMapping("/get/customerWiseTrips/{id}")
	public List<TripBooking> getTrips(@PathVariable("id") int customerId){
		List<TripBooking> trips = tripBookingService.viewAllTripsCustomer(customerId);
		return trips;
	}
}

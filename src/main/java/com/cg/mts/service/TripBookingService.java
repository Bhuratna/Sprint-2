package com.cg.mts.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.cg.mts.dao.TripBookingDao;
import com.cg.mts.repository.ITripBookingRepository;
//import com.cg.mts.util.Util;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.TripNotFoundException;

@Service
@Transactional
public class TripBookingService implements ITripBookingService {

	// private EntityManager entityManager;

	@Autowired
	private ITripBookingRepository tripBookingRepository;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tripBooking = tripBookingRepository.save(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		boolean checkIfExists = tripBookingRepository.existsById(tripBooking.getTripBookingId());
		if(!checkIfExists) {
			throw new TripNotFoundException("No Trip with trip booking id as " + tripBooking.getTripBookingId());
		}
		tripBooking = tripBookingRepository.save(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking deleteTripBooking(TripBooking tripBooking) {
		boolean checkIfExists = tripBookingRepository.existsById(tripBooking.getTripBookingId());
		if(!checkIfExists) {
			throw new TripNotFoundException("No Trip with trip booking id as " + tripBooking.getTripBookingId());
		}
		tripBookingRepository.delete(tripBooking);
		return tripBooking;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		List<TripBooking> trips = tripBookingRepository.findByCustomerId(customerId);
		if(trips.size() == 0) {
			throw new TripNotFoundException("No Trip with customer id " + customerId + " found");
		}
		return trips;
	}

	@Override
	public TripBooking calculateBill(int customerId) {
		TripBooking tripBooking = tripBookingRepository.findBillByCustomerId(customerId);
		if(tripBooking == null) {
			throw new TripNotFoundException("No trip bill found for the customer id "+ customerId);
		}
		return tripBooking;
	}

	// public TripBookingService() {
	// Util util = Util.getInstance();
	// entityManager = util.getEntityManager();
	// tripBookingDao = new TripBookingDao(entityManager);
	// }
	//
	// public TripBooking insertTripBooking(TripBooking tripBooking) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// tripBooking = tripBookingDao.insertTripBooking(tripBooking);
	// entityTransaction.commit();
	// return tripBooking;
	// }
	//
	// public TripBooking updateTripBooking(TripBooking tripBooking) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// tripBooking = tripBookingDao.updateTripBooking(tripBooking);
	// entityTransaction.commit();
	// return tripBooking;
	// }
	//
	// public TripBooking deleteTripBooking(TripBooking tripBooking) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// tripBooking = tripBookingDao.deleteTripBooking(tripBooking);
	// entityTransaction.commit();
	// return tripBooking;
	// }
	//
	// public List<TripBooking> viewAllTripsCustomer(int customerId) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// List<TripBooking> viewAllTrips =
	// tripBookingDao.viewAllTripsCustomer(customerId);
	// entityTransaction.commit();
	// return viewAllTrips;
	// }
	//
	// public TripBooking calculateBill(int customerId) {
	// // TripBooking tripBooking = em.find(TripBooking.class, customerId);
	// TripBooking tripBooking = tripBookingDao.calculateBill(customerId);
	// return tripBooking;
	// }
}
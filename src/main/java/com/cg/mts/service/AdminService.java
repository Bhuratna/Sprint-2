package com.cg.mts.service;

//import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

//import com.cg.mts.dao.AdminDao;
import com.cg.mts.exception.AdminNotFoundException;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.InvalidCustomerException;
import com.cg.mts.repository.IAdminRepository;
//import com.cg.mts.util.Util;
import com.cg.mts.entities.Admin;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.TripBooking;

@Service
@Transactional
//this is jpa repository only
public class AdminService implements IAdminService {

	@Autowired
	private IAdminRepository adminDao;

	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin = adminDao.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		admin = adminDao.save(admin);
		return admin;
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		Optional<Admin> adminOptional = adminDao.findById(adminId);
		Admin admin = adminOptional.get();
		adminDao.delete(admin);
		return admin;
		
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
//	private final EntityManager entityManager;

//	public AdminService() {
//		Util util = Util.getInstance();
//		entityManager = util.getEntityManager();
//		adminDao = new AdminDao(entityManager);
//	}

//	public Admin insertAdmin(Admin admin) {
//		try {
//			if (admin.getEmail() == null) {
//				throw new InvalidCustomerException("Null values not accepted");
//			} else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", admin.getEmail())) {
//				throw new InvalidCustomerException("email should be of type abc@gmail.com");
//			} else if (!Pattern.matches("(0/91)?[7-9][0-9]{9}", admin.getMobileNumber())) {
//				throw new InvalidCustomerException("phone number is not valid. it should 9600XXXXX");
//			} else if (admin.getPassword().length() < 6) {
//				throw new InvalidCustomerException("password should be six characters or more");
//			} else if (admin.getUsername().length() < 6) {
//				throw new InvalidCustomerException("username should be six characters or more");
//			} else if (admin.getMobileNumber() == null) {
//				throw new InvalidCustomerException("Mobile Number cannot be null");
//			} else if (admin.getPassword() == null) {
//				throw new InvalidCustomerException("Password cannot be null");
//			} else if (admin.getUsername() == null) {
//				throw new InvalidCustomerException("Username cannot be null");
//			}
//		} catch (InvalidCustomerException e) {
//			System.out.println(e.getMessage());
//			return new Admin();
//		}
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		admin = adminDao.insertAdmin(admin);
//		entityTransaction.commit();
//		return admin;
//	}
//
//	public Admin updateAdmin(Admin admin) {
//		try {
//			if (admin.getEmail() == null) {
//				throw new InvalidCustomerException("Null values not accepted");
//			} else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", admin.getEmail())) {
//				throw new InvalidCustomerException("email should be of type abc@gmail.com");
//			} else if (!Pattern.matches("(0/91)?[7-9][0-9]{9}", admin.getMobileNumber())) {
//				throw new InvalidCustomerException("phone number is not valid. it should 9600XXXXX");
//			} else if (admin.getPassword().length() < 6) {
//				throw new InvalidCustomerException("password should be six characters or more");
//			} else if (admin.getUsername().length() < 6) {
//				throw new InvalidCustomerException("username should be six characters or more");
//			} else if (admin.getMobileNumber() == null) {
//				throw new InvalidCustomerException("Mobile Number cannot be null");
//			} else if (admin.getPassword() == null) {
//				throw new InvalidCustomerException("Password cannot be null");
//			} else if (admin.getUsername() == null) {
//				throw new InvalidCustomerException("Username cannot be null");
//			}
//		} catch (InvalidCustomerException e) {
//			System.out.println(e.getMessage());
//			return new Admin();
//		}
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		try {
//			admin = adminDao.updateAdmin(admin);
//		} catch (AdminNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new Admin();
//		}
//		entityTransaction.commit();
//		return admin;
//	}
//
//	public Admin deleteAdmin(int adminId) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		Admin admin = null;
//		entityTransaction.begin();
//		try {
//			admin = adminDao.deleteAdmin(adminId);
//		} catch (AdminNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new Admin();
//		}
//		entityTransaction.commit();
//		return admin;
//	}
//
//	public List<TripBooking> getAllTrips(int customerId) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<TripBooking> li = null;
//		try {
//			li = adminDao.getAllTrips(customerId);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new ArrayList<TripBooking>();
//		}
//		entityTransaction.commit();
//		return li;
//	}
//
//	public List<TripBooking> getTripsCabwise() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<TripBooking> li = null;
//		try {
//			li = adminDao.getTripsCabwise();
//		} catch (CabNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new ArrayList<TripBooking>();
//		}
//		entityTransaction.commit();
//		return li;
//	}
//
//	public List<TripBooking> getTripsCustomerwise() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<TripBooking> li = adminDao.getTripsCustomerwise();
//		entityTransaction.commit();
//		return li;
//	}
//
//	public List<TripBooking> getTripsDatewise() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<TripBooking> li = adminDao.getTripsDatewise();
//		entityTransaction.commit();
//		return li;
//	}
//
//	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<TripBooking> li = null;
//		try {
//			li = adminDao.getAllTripsForDays(customerId, fromDate, toDate);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new ArrayList<TripBooking>();
//		}
//		entityTransaction.commit();
//		return li;
//	}

}
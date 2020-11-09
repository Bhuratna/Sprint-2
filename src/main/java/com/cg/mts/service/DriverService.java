package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.cg.mts.dao.DriverDao;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.exception.InvalidAdminException;
import com.cg.mts.exception.InvalidCustomerException;
import com.cg.mts.exception.InvalidDriverException;
import com.cg.mts.repository.IDriverRepository;
//import com.cg.mts.util.Util;
import com.cg.mts.entities.Driver;

@Service
@Transactional
public class DriverService implements IDriverService {

	// private EntityManager entityManager;

	@Autowired
	private IDriverRepository driverRepository;

	@Override
	public Driver insertDriver(Driver driver) {
		driver = driverRepository.save(driver);
		return driver;
	}

	@Override
	public Driver updateDriver(Driver driver) {
		boolean checkIfExists = driverRepository.existsById(driver.getDriverId());
		if(!checkIfExists) {
			throw new InvalidDriverException("Driver with driver id " + driver.getDriverId() + " does not exists");
		}
		driver = driverRepository.save(driver);
		return driver;
	}

	@Override
	public Driver deleteDriver(int driverId) {
		Optional<Driver> driverOptional = driverRepository.findById(driverId);
		if(!driverOptional.isPresent()) {
			throw new DriverNotFoundException("Driver with driver id " + driverId + " does not exists");
		}
		Driver driver = driverOptional.get();
		driverRepository.delete(driver);
		return driver;
	}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> drivers = driverRepository.viewBestDrivers();
		if(drivers.size() == 0) {
			throw new DriverNotFoundException("No Driver with best rating at the moment");
		}
		return drivers;
	}

	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> drivers = driverRepository.findById(driverId);
		if(!drivers.isPresent()) {
			throw new DriverNotFoundException("Driver with driver id " + driverId + " does not exists");
		}
		Driver driver = drivers.get();
		return driver;
	}

	// public DriverService() {
	// Util util = Util.getInstance();
	// entityManager = util.getEntityManager();
	// driverDao = new DriverDao(entityManager);
	// }
	//
	// public Driver insertDriver(Driver driver) {
	// try {
	// if (driver.getCab() == null) {
	// throw new InvalidDriverException("Cab cannot be null");
	// } else if (driver.getEmail() == null) {
	// throw new InvalidDriverException("driver email cannot be null");
	// } else if (driver.getLicenseNo() == null) {
	// throw new InvalidDriverException("driver license number cannot be null");
	// } else if (driver.getMobileNumber() == null) {
	// throw new InvalidDriverException("driver mobile number cannot be null");
	// } else if (driver.getPassword() == null) {
	// throw new InvalidDriverException("driver password cannot be null");
	// } else if (driver.getUsername() == null) {
	// throw new InvalidDriverException("driver username cannot be null");
	// } else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
	// driver.getEmail())) {
	// throw new InvalidDriverException("email should be of type abc@gmail.com");
	// } else if (!Pattern.matches("(0/91)?[7-9][0-9]{9}",
	// driver.getMobileNumber())) {
	// throw new InvalidDriverException("phone number is not valid. it should
	// 9600XXXXX");
	// } else if (driver.getPassword().length() < 6) {
	// throw new InvalidDriverException("password should be six characters or
	// more");
	// } else if (driver.getUsername().length() < 6) {
	// throw new InvalidDriverException("username should be six characters or
	// more");
	// }
	// } catch (InvalidDriverException e) {
	// System.out.println(e.getMessage());
	// return new Driver();
	// }
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// driver = driverDao.insertDriver(driver);
	// entityTransaction.commit();
	// return driver;
	// }
	//
	// public Driver updateDriver(Driver driver) {
	// try {
	// if (driver.getCab() == null) {
	// throw new InvalidDriverException("Cab cannot be null");
	// } else if (driver.getEmail() == null) {
	// throw new InvalidDriverException("driver email cannot be null");
	// } else if (driver.getLicenseNo() == null) {
	// throw new InvalidDriverException("driver license number cannot be null");
	// } else if (driver.getMobileNumber() == null) {
	// throw new InvalidDriverException("driver mobile number cannot be null");
	// } else if (driver.getPassword() == null) {
	// throw new InvalidDriverException("driver password cannot be null");
	// } else if (driver.getUsername() == null) {
	// throw new InvalidDriverException("driver username cannot be null");
	// } else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
	// driver.getEmail())) {
	// throw new InvalidDriverException("email should be of type abc@gmail.com");
	// } else if (!Pattern.matches("(0/91)?[7-9][0-9]{9}",
	// driver.getMobileNumber())) {
	// throw new InvalidDriverException("phone number is not valid. it should
	// 9600XXXXX");
	// } else if (driver.getPassword().length() < 6) {
	// throw new InvalidDriverException("password should be six characters or
	// more");
	// } else if (driver.getUsername().length() < 6) {
	// throw new InvalidDriverException("username should be six characters or
	// more");
	// }
	// } catch (InvalidDriverException e) {
	// System.out.println(e.getMessage());
	// return new Driver();
	// }
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// try {
	// driver = driverDao.updateDriver(driver);
	// } catch (DriverNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new Driver();
	// }
	// entityTransaction.commit();
	// return driver;
	// }
	//
	// public Driver deleteDriver(int driverId) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// Driver driver = null;
	// try {
	// driver = driverDao.deleteDriver(driverId);
	// } catch (DriverNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new Driver();
	// }
	// entityTransaction.commit();
	// return driver;
	// }
	//
	// public List<Driver> viewBestDrivers() {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// List<Driver> bestDrivers = null;
	// try {
	// bestDrivers = driverDao.viewBestDrivers();
	// } catch (DriverNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new ArrayList<Driver>();
	// }
	// entityTransaction.commit();
	// return bestDrivers;
	// }
	//
	// public Driver viewDriver(int driverId) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// Driver driver = null;
	// try {
	// driver = driverDao.viewDriver(driverId);
	// } catch (DriverNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new Driver();
	// }
	// entityTransaction.commit();
	// return driver;
	// }

}
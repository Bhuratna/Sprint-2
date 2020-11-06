package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.cg.mts.dao.CabDao;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.InvalidCabException;
import com.cg.mts.repository.ICabRepository;
//import com.cg.mts.util.Util;
import com.cg.mts.entities.Cab;

@Service
@Transactional
// this is using jpa repository
public class CabService implements ICabService {

	@Autowired
	private ICabRepository cabDao;

	@Override
	public Cab insertCab(Cab cab) {
		cab = cabDao.save(cab);
		return cab;
	}

	@Override
	public Cab updateCab(Cab cab) {
		cab = cabDao.save(cab);
		return cab;
	}

	@Override
	public Cab deleteCab(Cab cab) {
		cabDao.delete(cab);
		return cab;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		List<Cab> cabsOfCarType = cabDao.findByCarType(carType);
		return cabsOfCarType;
	}

	@Override
	public int countCabsOfType(String carType) {
		int count = cabDao.countCabsOfType(carType);
		return count;
	}

	// private final EntityManager entityManager;
	//
	// public CabService() {
	// Util util = Util.getInstance();
	// entityManager = util.getEntityManager();
	// cabDao = new CabDao(entityManager);
	// }
	//
	// public Cab insertCab(Cab cab) {
	// try {
	// if (cab.getCarType() == null) {
	// throw new InvalidCabException("Cab cannot be null");
	// }
	// } catch (InvalidCabException e) {
	// System.out.println(e.getMessage());
	// return new Cab();
	// }
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// cab = cabDao.insertCab(cab);
	// entityTransaction.commit();
	// return cab;
	// }
	//
	// public Cab updateCab(Cab cab) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// try {
	// cab = cabDao.updateCab(cab);
	// } catch (CabNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new Cab();
	// }
	// entityTransaction.commit();
	// return cab;
	// }
	//
	// public Cab deleteCab(Cab cab) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// try {
	// cab = cabDao.deleteCab(cab);
	// } catch (CabNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new Cab();
	// }
	// entityTransaction.commit();
	// return cab;
	// }
	//
	// public List<Cab> viewCabsOfType(String carType) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// List<Cab> listOfCabs = null;
	// try {
	// listOfCabs = cabDao.viewCabsOfType(carType);
	// } catch (CabNotFoundException e) {
	// System.out.println(e.getMessage());
	// entityTransaction.commit();
	// return new ArrayList<Cab>();
	// }
	// entityTransaction.commit();
	// return listOfCabs;
	// }
	//
	// public int countCabsOfType(String carType) {
	// EntityTransaction entityTransaction = entityManager.getTransaction();
	// entityTransaction.begin();
	// // int count = (Integer) entityManager.createQuery("Select count(*) from cab
	// // where cartype = 'cartype'").setParameter("cartype",
	// // carType).getSingleResult();
	//
	// int count = 0;
	//
	// try {
	// count = cabDao.countCabsOfType(carType);
	// } catch (CabNotFoundException e) {
	// System.out.println(e.getMessage());
	// }
	//
	// entityTransaction.commit();
	// return count;
	// }

}
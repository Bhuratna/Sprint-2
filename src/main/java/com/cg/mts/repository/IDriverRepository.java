package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

public interface IDriverRepository extends JpaRepository<Driver, Integer> {
//	public Driver insertDriver(Driver driver);
//	public Driver updateDriver(Driver driver)throws DriverNotFoundException;
//	public Driver deleteDriver(int driverId)throws DriverNotFoundException;
//	public Driver viewDriver(int driverId)throws DriverNotFoundException;
	@Query(value="Select a from Driver a where a.rating >=4.5f")
	public List<Driver>viewBestDrivers()throws DriverNotFoundException;
	public Driver findByUsernameAndPassword(String username, String password);
}
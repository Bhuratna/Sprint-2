package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Driver;
import com.cg.mts.service.IDriverService;

@RequestMapping("/driver")
@RestController
public class DriverController {

	@Autowired
	private IDriverService driverService;

	@PostMapping("/add")
	public Driver add(@RequestBody Driver driver) {
		driver = driverService.insertDriver(driver);
		return driver;
	}

	@PutMapping("/update/{id}")
	public Driver update(@PathVariable("id") int driverId, @RequestBody Driver newDriver) {
		newDriver.setDriverId(driverId);
		newDriver = driverService.updateDriver(newDriver);
		return newDriver;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int driverId) {
		Driver driver = driverService.deleteDriver(driverId);
	}

	@GetMapping("/get/{id}")
	public Driver getDriver(@PathVariable("id") int driverId) {
		Driver driver = driverService.viewDriver(driverId);
		return driver;
	}
	
	@GetMapping("/get/viewBestDrivers")
	public List<Driver> viewBestDrivers(){
		List<Driver> bestDrivers = driverService.viewBestDrivers();
		return bestDrivers;
	}
}
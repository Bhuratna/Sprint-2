package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Driver;
import com.cg.mts.service.IDriverService;

@RestController
public class DriverController {

	@Autowired
	private IDriverService driverService;

	@PostMapping("/add/driver")
	public Driver add() {
		Driver driver = new Driver();
		driver = driverService.insertDriver(driver);
		return driver;
	}
	
	@PutMapping("/update/driver")
	public Driver update() {
		Driver driver = new Driver();
		driver = driverService.updateDriver(driver);
		return driver;
	}
	
	@DeleteMapping("/delete/driver/{id}")
	public void delete(@PathVariable("id") int driverId) {
		Driver driver = driverService.deleteDriver(driverId);
	}
	
	@GetMapping("/get/driver/{id}")
	public Driver getDriver(@PathVariable("id") int driverId){
		Driver driver = driverService.viewDriver(driverId);
		return driver;
	}
}

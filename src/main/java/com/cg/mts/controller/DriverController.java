package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

/* This would signify we are in driver controller */
@RequestMapping("/driver")
/*
 * This annotation defines a class as a controller in spring boot. Rest
 * controller consists of @Controller and @ResponseBody annotation
 */
@RestController
@CrossOrigin("*")
public class DriverController {

	/*
	 * IDriverService is a interface, whose reference we are trying to
	 * call. @Autowired will dynamically create a object for it at run time,
	 * avoiding tight coupling
	 */
	@Autowired
	private IDriverService driverService;

	/*
	 * This method will add a driver object to the driver table. and return the
	 * driver object added back to the server
	 */
	@PostMapping("/add")
	public Driver add(@RequestBody Driver driver) {
		driver = driverService.insertDriver(driver);
		return driver;
	}

	/*
	 * This method will update a driver object whose id matches with the one we are
	 * passing. Once it updates, it will return the updated object back to the
	 * server
	 */
	@PutMapping("/update/{id}")
	public Driver update(@PathVariable("id") int driverId, @RequestBody Driver newDriver) {
		newDriver.setDriverId(driverId);
		newDriver = driverService.updateDriver(newDriver);
		return newDriver;
	}

	/*
	 * This method will delete a driver object from the database table, which we
	 * have passed in the method
	 */
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int driverId) {
		Driver driver = driverService.deleteDriver(driverId);
	}

	/*
	 * This method will return a driver object whose driver id we will pass in the
	 * url
	 */
	@GetMapping("/retrieve/{id}")
	public Driver getDriver(@PathVariable("id") int driverId) {
		Driver driver = driverService.viewDriver(driverId);
		return driver;
	}

	/*
	 * This method will return list of all the drivers whose rating is 4.5 and above
	 */
	@GetMapping("/retrieve/viewBestDrivers")
	public List<Driver> viewBestDrivers() {
		List<Driver> bestDrivers = driverService.viewBestDrivers();
		return bestDrivers;
	}

	/*
	 * This method will return driver object whose username and password matches
	 * with the one we would pass in the url
	 */
	@GetMapping("/validateDriver/{username}/{password}")
	public Driver validateDriver(@PathVariable("username") String username, @PathVariable("password") String password) {
		Driver driver = driverService.validateDriver(username, password);
		return driver;
	}
}

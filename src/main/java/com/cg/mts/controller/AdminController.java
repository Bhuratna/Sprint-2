package com.cg.mts.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.service.IAdminService;

/* This would signify that we are in admin controller right now */
@RequestMapping("/admin")
/*
 * This annotation defines a class as a controller in spring boot. Rest
 * controller consists of @Controller and @ResponseBody annotation
 */
@RestController
@CrossOrigin("*")
public class AdminController {

	/*
	 * IAdminService is a interface, whose reference we are trying to
	 * call. @Autowired will dynamically create a object for it at run time,
	 * avoiding tight coupling
	 */
	@Autowired
	private IAdminService adminService;

	/*
	 * This method will update the admin object, to a new admin object and return
	 * the updated object to the server
	 */
	@PutMapping("/update/{id}")
	public Admin update(@PathVariable("id") int adminId, @RequestBody Admin newAdmin) {
		newAdmin.setAdminId(adminId);
		newAdmin = adminService.updateAdmin(newAdmin);
		return newAdmin;
	}

	/*
	 * This method will add a new admin object to the database, and return the added
	 * object to the server
	 */
	@PostMapping("/add")
	public Admin add(@RequestBody Admin admin) {
		Admin newAdmin = new Admin(admin.getUsername(), admin.getPassword(), admin.getMobileNumber(), admin.getEmail());
		admin = adminService.insertAdmin(newAdmin);
		return admin;
	}

	/*
	 * This method will delete the admin object from database whose admin id matches
	 * with the one we have passed
	 */
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int adminId) {
		Admin admin = adminService.deleteAdmin(adminId);
	}

	/*
	 * This method will return a list of tripbookings from the table where id
	 * matches with the one we have passed
	 */
	@GetMapping("/retrieve/tripsBooking/{id}")
	public List<TripBooking> getTripBooking(@PathVariable("id") int id) {
		List<TripBooking> trp = adminService.getAllTrips(id);
		return trp;
	}

	/* This method will return a list of TripBooking based on each cabType */
	@GetMapping("/retrieve/getCabWise")
	public List<TripBooking> getCabWise() {
		List<TripBooking> trp = adminService.getTripsCabwise();
		return trp;
	}

	/* This method will return a list of TripBookings group based on customers */
	@GetMapping("/retrieve/getTripsCustomerwise")
	public List<TripBooking> getCustomerWise() {
		List<TripBooking> trp = adminService.getTripsCustomerwise();
		return trp;
	}

	/* This method will return a list of TripBookings based on Trip Dates */
	@GetMapping("/retrieve/getTripsDatewise")
	public List<TripBooking> getTripsDatewise() {
		List<TripBooking> trp = adminService.getTripsDatewise();
		return trp;
	}

	/*
	 * This method will return a list of TripBookings based on the customerId,
	 * fromDate, and toDate
	 */
	@GetMapping("/retrieve/getAllTripsForDays/{id}/{date1}/{date2}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("id") int customerId,
			@PathVariable("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDateTime,
			@PathVariable("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDateTime) {
		List<TripBooking> trp = adminService.getAllTripsForDays(customerId, fromDateTime, toDateTime);
		return trp;
	}

	/*
	 * This method will return admin object whose username and password matches with
	 * the one we would pass in the url
	 */
	@GetMapping("/validateAdmin/{username}/{password}")
	public Admin vaidateAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
		Admin admin = adminService.validateAdmin(username, password);
		return admin;
	}
}

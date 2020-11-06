package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/add/customer")
	public Customer add() {
		Customer customer = new Customer();
		customer = customerService.insertCustomer(customer);
		return customer;
	}
	
	@PutMapping("/update/customer")
	public Customer update() {
		Customer customer = new Customer("avc", "abc", "abc", "abc");
		customer = customerService.updateCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/delete/customer")
	public void delete(Customer customer) {
		customer = customerService.deleteCustomer(customer);
	}
	
	@GetMapping("/get/customer/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.viewCustomer(id);
		return customer;
	}

	@GetMapping("/get/customer/allCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> listOfAllCustomer = customerService.viewCustomers();
		return listOfAllCustomer;
	}
}

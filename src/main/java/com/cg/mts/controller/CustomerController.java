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

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		customer = customerService.insertCustomer(customer);
		return customer;
	}
	
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable("id") int customerId, @RequestBody Customer newCustomer) {
		newCustomer.setCustomerId(customerId);
		newCustomer = customerService.updateCustomer(newCustomer);
		return newCustomer;
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Customer customer) {
		customer = customerService.deleteCustomer(customer);
	}
	
	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.viewCustomer(id);
		return customer;
	}

	@GetMapping("/get/allCustomers")
	public List<Customer> getAllCustomers(){
		List<Customer> listOfAllCustomer = customerService.viewCustomers();
		return listOfAllCustomer;
	}
	
	@GetMapping("/get/validateCustomer/{username}/{password}")
	public Customer validateCustomer(@PathVariable("username") String username, @PathVariable("password") String password) {
		Customer customer = customerService.validateCustomer(username, password);
		return customer;
	}
}
package com.cg.mts.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//	public Customer insertCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//	public List<Customer>viewCustomers() throws CustomerNotFoundException;
//	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
//	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
	public Customer findByUsernameAndPassword(String username, String password);
	public Customer findByUsername(String username);
}
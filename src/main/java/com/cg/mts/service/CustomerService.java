package com.cg.mts.service;

//import com.cg.mts.dao.CustomerDao;
//import com.cg.mts.util.Util;
import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.InvalidCustomerException;
import com.cg.mts.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerDao;

	@Override
	public Customer insertCustomer(Customer customer) {
		customer = customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		boolean exists= customerDao.existsById(customer.getCustomerId());
        if(!exists){
            throw new InvalidCustomerException("Customer does not exists for id="+customer.getCustomerId());
        }
		customer=customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		Optional<Customer> optional=customerDao.findById(customer.getCustomerId());
		if(!optional.isPresent()){
            throw new CustomerNotFoundException("Product not found for id="+customer.getCustomerId());
        }
		customerDao.deleteById(customer.getCustomerId());
		
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() {
		List<Customer> listOfCustomer = customerDao.findAll();
		if(listOfCustomer.size()==0)
		{
			throw new CustomerNotFoundException("Customer not found for id="+customer);
		}
		return listOfCustomer;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> customers = customerDao.findById(customerId);
		Customer customer = customers.get();
		return customer;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

//	private EntityManager entityManager;
//
//	public CustomerService() {
//		Util util = Util.getInstance();
//		entityManager = util.getEntityManager();
//		customerDao = new CustomerDao(entityManager);
//	}
//
//	@Override
//	public Customer insertCustomer(Customer customer) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		try {
//			if (customer.getEmail() == null) {
//				throw new InvalidCustomerException("Null values not accepted");
//			} if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", customer.getEmail())) {
//				throw new InvalidCustomerException("email should be of type abc@gmail.com");
//			} if (!Pattern.matches("(0/91)?[7-9][0-9]{9}", customer.getMobileNumber())) {
//				throw new InvalidCustomerException("phone number is not valid. it should 9600XXXXX");
//			} if (customer.getPassword().length() < 6) {
//				throw new InvalidCustomerException("password should be 6 characters or more");
//			} if (customer.getUsername().length() < 6) {
//				throw new InvalidCustomerException("username should be six characters or more");
//			} if (customer.getMobileNumber() == null) {
//				throw new InvalidCustomerException("Mobile Number cannot be null");
//			} if (customer.getPassword() == null) {
//				throw new InvalidCustomerException("Password cannot be null");
//			} if (customer.getUsername() == null) {
//				throw new InvalidCustomerException("Username cannot be null");
//			}
//		} catch (InvalidCustomerException e) {
//			System.out.println(e.getMessage());
//			return new Customer();
//		}
//		entityTransaction.begin();
//		customer = customerDao.insertCustomer(customer);
//		entityTransaction.commit();
//		return customer;
//	}
//
//	@Override
//	public Customer updateCustomer(Customer customer) {
//		try {
//			if (customer.getEmail() == null) {
//				throw new InvalidCustomerException("Null values not accepted");
//			} else if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", customer.getEmail())) {
//				throw new InvalidCustomerException("email should be of type abc@gmail.com");
//			} else if (!Pattern.matches("(0/91)?[7-9][0-9]{9}", customer.getMobileNumber())) {
//				throw new InvalidCustomerException("phone number is not valid. it should 9600XXXXX");
//			} else if (customer.getPassword().length() < 6) {
//				throw new InvalidCustomerException("password should be 6 characters or more");
//			} else if (customer.getUsername().length() < 6) {
//				throw new InvalidCustomerException("username should be six characters or more");
//			} else if (customer.getMobileNumber() == null) {
//				throw new InvalidCustomerException("Mobile Number cannot be null");
//			} else if (customer.getPassword() == null) {
//				throw new InvalidCustomerException("Password cannot be null");
//			} else if (customer.getUsername() == null) {
//				throw new InvalidCustomerException("Username cannot be null");
//			}
//		} catch (InvalidCustomerException e) {
//			System.out.println(e.getMessage());
//			return new Customer();
//		}
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		try {
//			customer = customerDao.updateCustomer(customer);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new Customer();
//		}
//
//		entityTransaction.commit();
//
//		return customer;
//	}
//
//	@Override
//	public Customer deleteCustomer(Customer customer) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		try {
//			customer = customerDao.deleteCustomer(customer);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new Customer();
//		}
//
//		entityTransaction.commit();
//
//		return customer;
//	}
//
//	@Override
//	public List<Customer> viewCustomers() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		List<Customer> customers = null;
//		try {
//			customers = customerDao.viewCustomers();
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			entityTransaction.commit();
//			return new ArrayList<Customer>();
//		}
//		entityTransaction.commit();
//		return customers;
//	}
//
//	@Override
//	public Customer viewCustomer(int customerId) {
//		Customer customer = null;
//		try {
//			customer = customerDao.viewCustomer(customerId);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//
//			return new Customer();
//		}
//		;
//		return customer;
//	}
//
//	@Override
//	public Customer validateCustomer(String username, String password) {
//		Customer customer = null;
//		try {
//			customer = customerDao.validateCustomer(username, password);
//		} catch (CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//			// entityTransaction.commit();
//			return new Customer();
//		}
//		return customer;
//	}
}
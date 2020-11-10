package com.cg.mts;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.mts.entities.Customer;
import com.cg.mts.exception.InvalidCabException;
import com.cg.mts.exception.InvalidCustomerException;
import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTesting {
	@InjectMocks
	private CustomerService service;

	@Mock
	private ICustomerRepository repo;
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	 void testInsertCustomer() throws InvalidCustomerException {
		
		Customer cust = Mockito.mock(Customer.class);
		Customer updated=Mockito.mock(Customer.class);
		Mockito.when(repo.save(cust)).thenReturn(updated); 
		 Customer result =service.insertCustomer(cust);
		assertEquals(updated,result);

	}
	
	@Test
	void testUpdateCustomer_1()  {
		Customer cust = Mockito.mock(Customer.class);
		Customer updated=Mockito.mock(Customer.class);
	   int custId=50;
	   Mockito.when(cust.getCustomerId()).thenReturn(custId);
		Mockito.when(repo.existsById(50)).thenReturn(true);
		
		Mockito.when(repo.save(cust)).thenReturn(updated);
		Customer result=service.updateCustomer(cust);
		assertEquals(updated,result);

	}
	@Test
	void testUpdateCustomer_2()
	{
		Customer cust = Mockito.mock(Customer.class);
		int customerId=20;
		 Mockito.when(cust.getCustomerId()).thenReturn(customerId);
			Mockito.when(repo.existsById(customerId)).thenReturn(false);
			Executable exe=()->service.updateCustomer(cust);
			assertThrows(InvalidCustomerException.class,exe);
	} 
}
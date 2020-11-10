package com.cg.mts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.Cab;
import com.cg.mts.entities.Customer;
import com.cg.mts.exception.InvalidCustomerException;

import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.service.CustomerService;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class CustomerServiceTesting {
		@Autowired
		private CustomerService service;

		@MockBean
		private ICustomerRepository repo;
		@BeforeEach
		void setUp() throws Exception {
		}
		
		@Test
		 void testCreateCustomer() throws InvalidCustomerException {

			Customer cust = new Customer("Bhura","fhgvhg","7023514781", "gvgv");
			

			Mockito.when(repo.save(cust)).thenReturn(cust); 
			assertThat(service.insertCustomer(cust)).isEqualTo(cust);

		}
		@Test
		public void testDeleteCustomer() {
			Customer cust = new Customer("Bhura","fhgvhg","7023514781", "gvgv");
			
			Mockito.when(repo.findById(1)).thenReturn(Optional.of(cust));
			Mockito.when(repo.existsById(cust.getCustomerId())).thenReturn(false);

			assertFalse(repo.existsById(cust.getCustomerId()));
		}
	}

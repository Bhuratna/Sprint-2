package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customertable")
public class Customer extends AbstractUser {

	@GeneratedValue
	@Id
	private int customerId;

	public Customer(String username, String password, String mobileNumber, String email) {
		super(username, password, mobileNumber, email);
	}

	public Customer() {
		
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
package com.cg.mts.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="drivertable")
public class Driver extends AbstractUser {
	@Id
	@GeneratedValue
	private int driverId;
	private String licenseNo;
	@Autowired
	@OneToOne(cascade = { CascadeType.ALL })
	private Cab cab;
	private float rating;
	@OneToMany(mappedBy = "driver")
	private List<TripBooking> list;

	public Driver(String username, String password, String mobileNumber, String email, String licenseNo, Cab cab,
			float rating) {
		super(username, password, mobileNumber, email);
		// this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}

	public Driver() {
		super();
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<TripBooking> getList() {
		return list;
	}

	public void setList(List<TripBooking> list) {
		this.list = list;
	}
}
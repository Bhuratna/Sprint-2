package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(query="select c from Cab c where c.carType = :cartype", name="Find cabs from cars"),
	@NamedQuery(query="select count(c) from Cab c where c.carType = :cartype", name = "find cabs from cartype")
})
public class Cab {
	@Id
	@GeneratedValue
	private int cabId;
	private String carType;
	private float perKmRate;

	public Cab(String carType, float perKmRate) {
		super();
//		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public Cab() {
		super();
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
}
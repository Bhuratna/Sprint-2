package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabtable")
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
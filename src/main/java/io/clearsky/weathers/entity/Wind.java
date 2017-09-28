package io.clearsky.weathers.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {
	@Id
	private String id=UUID.randomUUID().toString();
	
	private double speed;
	private int degree;

	public Wind() {
		this.id=UUID.randomUUID().toString();
	}
	
	
	public void setId(String windid) {
		this.id = windid;
	}
	
	public String getId() {
		return id;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
}
package io.clearsky.weathers.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@NamedQueries({
	@NamedQuery(name="Weather.getCities",query= "SELECT DISTINCT w.city FROM Weather w"),
	@NamedQuery(name="Weather.getWeather",query= "SELECT w FROM Weather w where w.city=:pCity")
})
@Entity
public class Weather {
	
	@Id
	private String id;
	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int temperature;
	
	@JoinColumn(name="windid")
	@OneToOne(cascade=CascadeType.ALL)
	private Wind wind;
	
	private String timestamp;

	
	public Weather() {
		this.id=UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
		this.wind.setId(wind.getId());
		this.wind.setSpeed(wind.getSpeed());
		this.wind.setDegree(wind.getDegree());
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public Wind getWind() {
		return wind;
	}
	public String getDescription() {
		return description;
	}
	public int getHumidity() {
		return humidity;
	}
	public int getPressure() {
		return pressure;
	}
	public String getTimestamp() {
		return timestamp;
	}
	
	public int getTemperature() {
		return temperature;
	}

}
package io.clearsky.weathers.service;

import java.util.List;

import io.clearsky.weathers.entity.Weather;
import io.clearsky.weathers.entity.Wind;
 

public interface WeatherService {
	
	public List<String> getCities();
	
	public Weather create(Weather weather);
	
	public Weather getLatestWeather(String city);
	
	public Wind getWind(String city);
	public String getDescription(String city);
	public int getHumidity(String city);
	public int getPressure(String city);
	public String getTimestamp(String city);
	public int getTemperature(String city);
	public int getDegree(String city);
	public double getSpeed(String city);
	
	public Weather getHourlyAveragedWeather(String city);
	
	public Weather getDailyAveragedWeather(String city);
}

package io.clearsky.weathers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.clearsky.weathers.dao.WeatherDAO;
import io.clearsky.weathers.entity.Weather;
import io.clearsky.weathers.entity.Wind;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	WeatherDAO weatherDao;

	@Override
	public List<String> getCities() {
		return weatherDao.getCities();
	}

	@Override
	public Weather getLatestWeather(String city) {
		return weatherDao.getLatestWeather(city);
	}

	@Override
	public Wind getWind(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getWind(city);
	}

	@Override
	public String getDescription(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getDescription(city);
	}

	@Override
	public int getHumidity(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getHumidity(city);
	}

	@Override
	public int getPressure(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getPressure(city);
	}

	@Override
	public String getTimestamp(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getTimestamp(city);
	}

	@Override
	public int getTemperature(String city) {
		// TODO Auto-generated method stub
		return weatherDao.getTemperature(city);
	}

	@Override
	public Weather getHourlyAveragedWeather(String city) {
		return weatherDao.getHourlyAveragedWeather(city);
	}

	@Override
	public Weather getDailyAveragedWeather(String city) {
		return weatherDao.getDailyAveragedWeather(city);
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		return weatherDao.create(weather);
	}

	@Override
	public int getDegree(String city) {
		return weatherDao.getDegree(city);
	}

	@Override
	public double getSpeed(String city) {
		return weatherDao.getSpeed(city);
	}



}

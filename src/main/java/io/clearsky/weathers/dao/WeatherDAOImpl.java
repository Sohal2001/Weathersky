package io.clearsky.weathers.dao;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.clearsky.weathers.entity.Weather;
import io.clearsky.weathers.entity.Wind;


@Repository
public class WeatherDAOImpl implements WeatherDAO{
	
	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	
	@Override
	public List<String> getCities() {
		TypedQuery<String> query=em.createNamedQuery("Weather.getCities", String.class);
		return query.getResultList();
	}

	@Override
	public Weather getLatestWeather(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first();
	}

	@Override
	public Wind getWind(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getWind();
	}
	
	@Override
	public String getDescription(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getDescription();
	}
	
	@Override
	public int getHumidity(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getHumidity();
	}
	
	@Override
	public int getPressure(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getPressure();
	}
	
	@Override
	public String getTimestamp(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getTimestamp();
	}
	
	@Override
	public int getTemperature(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getTemperature();
	}
	@Override
	public int getDegree(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getWind().getDegree();
	}

	@Override
	public double getSpeed(String city) {
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}		
		return  t.first().getWind().getSpeed();
	}
	
	@Override
	public Weather getHourlyAveragedWeather(String city) {
		int pressure=0,temperature=0,degree=0,humidity=0;
		double speed=0;
		String o1="",o2="";
		
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}
		
		Iterator<Weather> it=t.iterator();
		while (it.hasNext()) {
			Weather weather = (Weather) it.next();
			pressure+=weather.getPressure();
			temperature+=weather.getTemperature();
			humidity+=weather.getHumidity();
			degree+=weather.getWind().getDegree();
			speed+=weather.getWind().getSpeed();			
			if(weather.equals(t.first()))
			{
				o1=weather.getTimestamp();
			}else if(weather.equals(t.last())){
				o2=weather.getTimestamp();
			}		
		}
		
		Instant i1 = OffsetDateTime.parse(o1, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts1 = Timestamp.from(i1);
        Instant i2 = OffsetDateTime.parse(o2, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts2 = Timestamp.from(i2);		
        
        int hours=Long.valueOf((long)(ts1.getTime()-ts2.getTime())/(long)3600000L).intValue();
        System.out.println(hours);
        
        Weather weather=t.first();
        weather.setHumidity(humidity/hours);
        weather.setPressure(pressure/hours);
        weather.setTemperature(temperature/hours);
        Wind w=weather.getWind();
        w.setDegree(degree/hours);
        w.setSpeed(speed/hours);
        weather.setWind(w);
        
		return weather;
	}

	@Override
	public Weather getDailyAveragedWeather(String city) {
		int pressure=0,temperature=0,degree=0,humidity=0;
		double speed=0;
		String o1="",o2="";
		
		TypedQuery<Weather> query=em.createNamedQuery("Weather.getWeather", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> wList= query.getResultList();
		TreeSet<Weather> t =new TreeSet<>(new MyComparator());
		for (Weather weather : wList) {
			t.add(weather);
		}
		
		Iterator<Weather> it=t.iterator();
		while (it.hasNext()) {
			Weather weather = (Weather) it.next();
			pressure+=weather.getPressure();
			temperature+=weather.getTemperature();
			humidity+=weather.getHumidity();
			degree+=weather.getWind().getDegree();
			speed+=weather.getWind().getSpeed();			
			if(weather.equals(t.first()))
			{
				o1=weather.getTimestamp();
			}else if(weather.equals(t.last())){
				o2=weather.getTimestamp();
			}		
		}
		
		Instant i1 = OffsetDateTime.parse(o1, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts1 = Timestamp.from(i1);
        Instant i2 = OffsetDateTime.parse(o2, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts2 = Timestamp.from(i2);		
        
        int days=Long.valueOf((long)(ts1.getTime()-ts2.getTime())/((long)86400000L)).intValue();
        System.out.println(days);
        
        Weather weather=t.first();
        weather.setHumidity(humidity/t.size());
        weather.setPressure(pressure/t.size());
        weather.setTemperature(temperature/t.size());
        Wind w=weather.getWind();
        w.setDegree(degree/t.size());
        w.setSpeed(speed/t.size());
        weather.setWind(w);
        
		return weather;
	}

	@Override
	public Weather create(Weather weather) {
		em.persist(weather);
		return weather;
	}	
	
}

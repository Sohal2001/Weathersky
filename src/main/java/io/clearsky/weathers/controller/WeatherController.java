package io.clearsky.weathers.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.clearsky.weathers.constants.URI;
import io.clearsky.weathers.entity.Weather;
import io.clearsky.weathers.entity.Wind;
import io.clearsky.weathers.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@RestController
@RequestMapping(value=URI.WEATHER)
@Api(tags="weathers")
@CrossOrigin
public class WeatherController {
	
	@Autowired
	WeatherService service;

	
	@RequestMapping(method=RequestMethod.GET,value=URI.CITIES)
	@ApiOperation(value = "Find All Cities Which reported Weather in past", notes = "Returns a list of city in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> getCities() {
		return service.getCities();
	}

	@RequestMapping(method=RequestMethod.GET,value=URI.CITY)
	@ApiOperation(value = "Find Latest Reeported Weather by city", notes = "Returns a weather by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather getLatestWeather(@PathVariable("city") String city) {
		return service.getLatestWeather(city);
	}

	@RequestMapping(method=RequestMethod.GET,value="/{city}/wind")
	@ApiOperation(value = "Find Wind by city", notes = "Returns a wind by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Wind getWind(@PathVariable("city") String city) {
		return service.getWind(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/description")
	@ApiOperation(value = "Find Description by city", notes = "Returns a Description by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String getDescription(@PathVariable("city") String city) {
		return service.getDescription(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/humidity")
	@ApiOperation(value = "Find Humidity by city", notes = "Returns a Humidity by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public int getHumidity(@PathVariable("city") String city) {
		return service.getHumidity(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/pressure")
	@ApiOperation(value = "Find Pressure by city", notes = "Returns a Pressure by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public int getPressure(@PathVariable("city") String city) {
		return service.getPressure(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/timestamp")
	@ApiOperation(value = "Find Timestamp by city", notes = "Returns a Timestamp by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String getTimestamp(@PathVariable("city") String city) {
		return service.getTimestamp(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/temperature")
	@ApiOperation(value = "Find Temperature by city", notes = "Returns a Temperature by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public int getTemperature(@PathVariable("city") String city) {
		return service.getTemperature(city);
	}
	@RequestMapping(method=RequestMethod.GET,value="/{city}/windspeed")
	@ApiOperation(value = "Find Degree of wind by city", notes = "Returns a Degree of wind by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public int getDegree(@PathVariable("city") String city) {
		return service.getDegree(city);
	}

	@RequestMapping(method=RequestMethod.GET,value="/{city}/winddegree")	
	@ApiOperation(value = "Find Speed of wind by city", notes = "Returns a Speed of wind by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public double getSpeed(@PathVariable("city") String city) {
		return service.getSpeed(city);
	}
	

	@RequestMapping(method=RequestMethod.GET,value="/{city}/hourlyaverage")
	@ApiOperation(value = "Find HourlyAverage by city", notes = "Returns a HourlyAverage by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather getHourlyAveragedWeather(@PathVariable("city") String city) {
		return service.getHourlyAveragedWeather(city);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{city}/dailyaverage")
	@ApiOperation(value = "Find DailyAverage by city", notes = "Returns a DailyAverage by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather getDailyAveragedWeather(@PathVariable("city") String city) {
		return service.getDailyAveragedWeather(city);
	}

	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Create Weather Entry", notes = "Returns a whole weather object with added id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather create(@RequestBody Weather weather) {
		return service.create(weather);
	}
}

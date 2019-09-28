package com.me.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.weather.model.Weather;
import com.me.weather.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/getWeather/{city}/{country}")
    public Weather greeting(@PathVariable (value="city") String city, @PathVariable(value="country") String country) {
		System.out.println("start weather :: "+city);
        return weatherService.getWeather(city, country);
    }
}

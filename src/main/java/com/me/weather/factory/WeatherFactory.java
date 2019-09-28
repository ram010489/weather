package com.me.weather.factory;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.me.weather.client.GetWeather;
import com.me.weather.model.Weather;

public class WeatherFactory {

	public static GetWeather createWeather(String city, String country) {
		GetWeather weather = new GetWeather();
		weather.setCityName(city);
		weather.setCountryName(country);
		return weather;
	}
	
	public static Weather createWeatherPojo(String response) {
		XmlMapper xmlMapper = new XmlMapper();
		Weather weather = null;
		try {
			weather = xmlMapper.readValue(response, Weather.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return weather;
	}
}

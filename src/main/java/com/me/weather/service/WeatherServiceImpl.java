package com.me.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.weather.SOAPConnector;
import com.me.weather.client.GetWeather;
import com.me.weather.client.GetWeatherResponse;
import com.me.weather.factory.WeatherFactory;
import com.me.weather.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private SOAPConnector soapConnector;
	
	@Override
	public Weather getWeather(String city, String country) {
		GetWeather weatherEntity = WeatherFactory.createWeather(city, country);
		System.out.println("Start connection with soap >>> ");

		GetWeatherResponse response =(GetWeatherResponse) soapConnector.callWebService("http://localhost:8080/GlobalWeather", weatherEntity);
		String resStr = response.getGetWeatherResult();
		System.out.println("My data >>> "+resStr);
		Weather weatherPojo = WeatherFactory.createWeatherPojo(resStr);
		return weatherPojo;
	}

}

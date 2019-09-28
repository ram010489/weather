package com.me.weather.service;

import com.me.weather.model.Weather;

public interface WeatherService {

	public Weather getWeather(String city, String country);
}

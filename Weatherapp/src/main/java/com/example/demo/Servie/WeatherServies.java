package com.example.demo.Servie;

import com.example.demo.Entity.City;

public interface WeatherServies {

	
	public void saveWeather(City city);
	
	City getWeatherdata(int  cId );
	
	java.util.List<City> getallWeatherdata();
	
	 
}

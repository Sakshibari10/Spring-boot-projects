package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.City;
import com.example.demo.Servie.WeatherServies;

@RestController
public class WeatherController {

@Autowired
WeatherServies weatherServies;
	
@PostMapping("/weather")
	public String adddata(@RequestBody City city)
	{
		
		weatherServies.saveWeather(city);
		return "data add";
		
	}

@GetMapping("/weather/{cId}")
    public City getWeatherdata(@PathVariable("cId") int cId)
    {
    return	weatherServies.getWeatherdata(cId);
    }
    
@GetMapping("/weathers")
    public List<City> getallWeatherdb()
    {
		return weatherServies.getallWeatherdata()  ;
    	
    }
}

package com.example.demo.Servie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.City;
import com.example.demo.Repository.WeatherRepo;
import com.example.demo.cache.Cache;


@Service
public class WeatherservieImp implements WeatherServies {

	@Autowired 
	WeatherRepo weatherRepo;
	@Autowired
	Cache cache; 
	
	@Override
	public void saveWeather(City city) {
		weatherRepo.save(city);
		
	}

	@Override
	public City getWeatherdata(int cId) {
		
		if(cache.check(cId))
		{
		
			cache.getCachedata(cId);
		}
		System.out.println("get data form db");
		City c=	weatherRepo.findById(cId).get();
		cache.storeData(c);
			return c;
	
	}

	@Override
	public List<City> getallWeatherdata() {
		return	weatherRepo.findAll();
		
	}

}

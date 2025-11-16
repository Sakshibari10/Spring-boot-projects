package com.example.demo.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.City;
import com.example.demo.Repository.WeatherRepo;
@Component
public class Cache {

	private Cache()
	{
		
	}
	
	@Autowired
	WeatherRepo weatherRepo;
	
	Map<Integer, City> m =new HashMap<>();
	
	
	public boolean check (int cId)
	{
		return m.containsKey(cId);
			
	}
	
	public void fechdatafromdb()
	{
		
		List<City> l= weatherRepo.findAll();
		{
			for (City city : l) {
				m.put(city.getcId(), city);
				
			}
		}
	}
	
	public void storeData(City city)
	{
		m.put(city.getcId(), city);
	
	}
	
	public City getCachedata(int cId)
	{
		System.out.println("this get data from cache");
		return m.get(cId);
	}
	
	public void clearCache()
	{
		m.clear();
	}
}

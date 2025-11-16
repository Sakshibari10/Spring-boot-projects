package com.example.demo.shedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.cache.Cache;

@Component
@EnableScheduling
public class CacheSchedular {

	@Autowired
	Cache cache;
	
	@Scheduled(fixedDelay = 50000)
	public void excuet()
	{
		cache.clearCache();
		cache.fechdatafromdb();
		
	}
}

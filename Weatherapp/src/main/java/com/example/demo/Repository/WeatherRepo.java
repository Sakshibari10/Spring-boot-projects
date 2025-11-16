package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Entity.City;

public interface WeatherRepo extends JpaRepository<City, Integer> {

}

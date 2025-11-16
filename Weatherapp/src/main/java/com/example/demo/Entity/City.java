package com.example.demo.Entity;


import jakarta.persistence.Id; // ✅ Correct import
import jakarta.persistence.Entity;

@Entity
public class City {

	@Id
	private int cId;
	private String name;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

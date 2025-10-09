package com.example.demo.Servies;

import com.example.demo.Entity.User;

public interface EmailServies {

	String  sendOtptotheEmail(String email);  

	

	boolean verifyEmail(String email, String sendOtp);


	
	
}

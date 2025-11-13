package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentUser")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String passWord;
//	this for otp 
	private String otp;
	private LocalDateTime otpExpriry;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getOtpExpriry() {
		return otpExpriry;
	}
	public void setOtpExpriry(LocalDateTime otpExpriry) {
		this.otpExpriry = otpExpriry;
	}
	
	
	
}

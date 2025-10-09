package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException {

	private String Massege;
	private HttpStatus httpStatus;
	public String getMassege() {
		return Massege;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public StudentException(String massege, HttpStatus httpStatus) {
		super();
		Massege = massege;
		this.httpStatus = httpStatus;
	}
	public StudentException() {
		super();
	}
	
	
	
	
}

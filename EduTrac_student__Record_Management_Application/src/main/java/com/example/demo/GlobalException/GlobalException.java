package com.example.demo.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.StudentException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(exception = StudentException.class)
	public ResponseEntity handalStudentException(StudentException se)
	{
		return new ResponseEntity(se.getMassege(),se.getHttpStatus());
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity handalAllException(Exception e)
	{
		return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}

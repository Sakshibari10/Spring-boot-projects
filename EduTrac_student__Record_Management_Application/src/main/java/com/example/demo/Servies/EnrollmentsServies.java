package com.example.demo.Servies;

import java.util.List;

import com.example.demo.Entity.Enrollment;

public interface EnrollmentsServies {

	Enrollment saveEnrollment (Enrollment enrollment);
	
	List<Enrollment> getEnrollmentbyuser(int user_Id);
	
	List<Enrollment> getEnrollmentbyBatch(int b_Id);
		
}

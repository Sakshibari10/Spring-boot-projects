package com.example.demo.Servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Enrollment;
import com.example.demo.repositery.EnrollmentRepo;

@Service
public class EnrollmentsServiesimpl implements EnrollmentsServies {

	@Autowired
	EnrollmentRepo enrollmentRepo;
	
	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
	
		return enrollmentRepo.save(enrollment) ;
	}

	@Override
	public List<Enrollment> getEnrollmentbyuser(int user_Id) {
	
		return enrollmentRepo.findbyuserId(user_Id) ;
	}

	@Override
	public List<Enrollment> getEnrollmentbyBatch(int b_Id) {
	
		return enrollmentRepo.findbyBatchid(b_Id);
	}

}

package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Enrollment;



public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {

	  // Fetch all enrollments for a specific user
	List<Enrollment> findbyuserId(int user_Id);
	
	 // Fetch enrollments for a given batch
	List<Enrollment> findbyBatchid(int b_Id);
	
//    // Fetch enrollments filtering by both student and course
//	List<Enrollment> findbyuseridandCourseid(int user_Id, int cId);
//	
	
}

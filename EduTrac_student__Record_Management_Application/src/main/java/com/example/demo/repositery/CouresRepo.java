package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Course;

@Repository
public interface CouresRepo extends JpaRepository<Course, Integer> {
	



	 @Query("SELECT c.syllbusfilePath FROM Course c WHERE c.cId = :cId")
	    byte[] findSyllabusByCourseId(@Param("cId") int cId);
	
}

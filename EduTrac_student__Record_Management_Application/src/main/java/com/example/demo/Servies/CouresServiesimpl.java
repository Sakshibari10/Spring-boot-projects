package com.example.demo.Servies;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Course;
import com.example.demo.Exception.StudentException;
import com.example.demo.repositery.CouresRepo;

@Service
public class CouresServiesimpl implements CouresServies {

	@Autowired
	CouresRepo couresRepo;
	
	
	@Override
	public void saveCourse(Course course) {
	    Integer id = course.getcId();
	    if (id != null && couresRepo.existsById(id)) {
	        throw new StudentException("This course id already exists", HttpStatus.CONFLICT);
	    }
	    couresRepo.save(course);
	}

	@Override
	public Course getCourse(int cId) {
		
		Course course= new Course();
		if(course.getcId()!=cId)
		{
			throw new StudentException(" user not found by this id",HttpStatus.BAD_REQUEST);
		}
		return couresRepo.findById(cId).get();
	}

	@Override
	public List<Course> getallCourses() {
		
		return couresRepo.findAll();
		
	}

	@Override
	public void savesyllabusFile(int cId, MultipartFile file) {
	    Course course = couresRepo.findById(cId)
	            .orElseThrow(() -> new StudentException("Course not found with ID: " + cId, HttpStatus.NOT_FOUND));

	    try {
	        course.setSyllbusfilePath(file.getBytes());
	        course.setSyllbusfileName(file.getOriginalFilename());
	        course.setUpdateDate(LocalDateTime.now());
	    } catch (IOException e) {
	        throw new StudentException("Failed to read syllabus file: " + e.getMessage(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    couresRepo.save(course);
	}



	@Override
	public byte[] getSyllabusFile(int cId) {
	    return couresRepo.findById(cId)
	        .map(Course::getSyllbusfilePath)
	        .orElseThrow(() -> new StudentException(
	            "Course not found with id " + cId, HttpStatus.NOT_FOUND
	        ));
	}

	
	
}

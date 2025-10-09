package com.example.demo.Servies;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Course;

public interface CouresServies {

	void saveCourse(Course course);
	
	Course getCourse(int cId);
	
	List<Course>  getallCourses();
	
	public void savesyllabusFile(int courseId, MultipartFile file);
	
	
	public byte[] getSyllabusFile(int courseId) ;

	
}

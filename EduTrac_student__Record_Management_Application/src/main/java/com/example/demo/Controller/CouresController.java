package com.example.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.*;


import com.example.demo.Entity.Course;
import com.example.demo.Servies.CouresServies;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CouresController {

	@Autowired
	CouresServies couresServies;

	@PostMapping("/Course")
	public ResponseEntity saveCourse(@RequestBody Course course) {
		couresServies.saveCourse(course);
		return new ResponseEntity("data is save ", HttpStatus.OK);

	}

	@GetMapping("/Course/{cId}")
	public ResponseEntity getCoursebyid(@PathVariable("cId") int cId) {

		return new ResponseEntity(couresServies.getCourse(cId), HttpStatus.OK);

	}

	@GetMapping("Courses")
	public ResponseEntity getallCoursesdata() {

		return new ResponseEntity(couresServies.getallCourses(), HttpStatus.OK);

	}
	
	
	private static final String MULTIPART = "multipart/form-data";
	@PostMapping(value = "/courses/{cId}/uploadSyllabus", consumes = MULTIPART)
	    public ResponseEntity<String> uploadSyllabus(
	    		@PathVariable int cId,
	            @RequestPart(value = "file", required = true) MultipartFile file) {

	        if (file == null || file.isEmpty()) {
	            return ResponseEntity.badRequest().body("No file uploaded!");
	        }
	        couresServies.savesyllabusFile(cId, file);
	        return ResponseEntity.ok("Syllabus uploaded successfully!");
	    }

	 
	@GetMapping("/download/{cId}")
	public void downloadSyllabus(@PathVariable int cId, HttpServletResponse response) throws IOException {
	    byte[] data = couresServies.getSyllabusFile(cId);

	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment; filename=\"syllabus-" + cId + ".pdf\"");
	    response.setContentLength(data.length);

	    ServletOutputStream out = response.getOutputStream();
	    out.write(data);
	    out.flush();
	}


	
	
}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Enrollment;
import com.example.demo.Servies.EnrollmentsServies;

@RestController
public class EnrollmentController {

	@Autowired
	EnrollmentsServies enrollmentsServies;

	@PostMapping("/Enrollment")
	public ResponseEntity saveEnrollment(@RequestBody Enrollment enrollment) {
		enrollmentsServies.saveEnrollment(enrollment);

		return new ResponseEntity("sava Enrollment", HttpStatus.OK);
	}

	@GetMapping("/Enrollment/{user_Id}")
	public ResponseEntity getEnrollmentbyUserId(@PathVariable("user_Id") int user_Id) {
		return new ResponseEntity(enrollmentsServies.getEnrollmentbyuser(user_Id), HttpStatus.ACCEPTED);

	}

	@GetMapping("/Enrollments/{b_Id}")
	public ResponseEntity getEnrollmentbybatchId(@PathVariable("b_Id") int b_Id) {

		return new ResponseEntity(enrollmentsServies.getEnrollmentbyBatch(b_Id), HttpStatus.OK);

	}
}

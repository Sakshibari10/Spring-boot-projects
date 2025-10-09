package com.example.demo.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollment_Id;
	
	private LocalDate enrollmentDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id")
	private User user;
	 
	 @ManyToAny(fetch = FetchType.LAZY)
	 @JoinColumn(name = "cId")
	 private Course course;
	 
	 @ManyToAny(fetch = FetchType.LAZY)
	 @JoinColumn(name="batch_Id")
	 private Batches batches;

	 public int getEnrollment_Id() {
		 return enrollment_Id;
	 }

	 public void setEnrollment_Id(int enrollment_Id) {
		 this.enrollment_Id = enrollment_Id;
	 }

	 public LocalDate getEnrollmentDate() {
		 return enrollmentDate;
	 }

	 public void setEnrollmentDate(LocalDate enrollmentDate) {
		 this.enrollmentDate = enrollmentDate;
	 }

	 public User getUser() {
		 return user;
	 }

	 public void setUser(User user) {
		 this.user = user;
	 }

	 public Course getCourse() {
		 return course;
	 }

	 public void setCourse(Course course) {
		 this.course = course;
	 }

	 public Batches getBatches() {
		 return batches;
	 }

	 public void setBatches(Batches batches) {
		 this.batches = batches;
	 }
	
	 
	 
}

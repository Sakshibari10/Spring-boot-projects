package com.example.demo.Entity;

import java.text.DateFormat;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Batches {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int batch_Id;
private String batch_No;
private DateFormat batch_start_Date;
private DateFormat batch_end_Date;
private int batch_Time;
private int batch_capacity;
final private String batch_mode = "online and offline";

@OneToMany(mappedBy = "Batches", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Enrollment> enrollments;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "cId")
private Course course;

public int getB_Id() {
	return batch_Id;
}
public void setB_Id(int b_Id) {
	this.batch_Id = b_Id;
}
public String getBatch_No() {
	return batch_No;
}
public void setBatch_No(String batch_No) {
	this.batch_No = batch_No;
}
public DateFormat getBatch_start_Date() {
	return batch_start_Date;
}
public void setBatch_start_Date(DateFormat batch_start_Date) {
	this.batch_start_Date = batch_start_Date;
}
public DateFormat getBatch_end_Date() {
	return batch_end_Date;
}
public void setBatch_end_Date(DateFormat batch_end_Date) {
	this.batch_end_Date = batch_end_Date;
}
public int getBatch_Time() {
	return batch_Time;
}
public void setBatch_Time(int batch_Time) {
	this.batch_Time = batch_Time;
}
public int getBatch_capacity() {
	return batch_capacity;
}
public void setBatch_capacity(int batch_capacity) {
	this.batch_capacity = batch_capacity;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public String getBatch_mode() {
	return batch_mode;
}

}
package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
@jakarta.persistence.Table(name = "Courses")
public class Course {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_seq")
	@SequenceGenerator(name = "course_id_seq", sequenceName = "course_id_seq", allocationSize = 1)
	private Integer cId;

	private String cName;
	@Transient
	private final String cDuration = "6 months";

	private String syllbusfileName;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] syllbusfilePath;

	private LocalDateTime createDate;
	private LocalDateTime updateDate;

	@OneToMany(mappedBy = "Course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Enrollment> enrollments;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Batches> batches;

	public List<Batches> getBatches() {
		return batches;
	}

	public void setBatches(List<Batches> batches) {
		this.batches = batches;
	}

	public Integer getcId() {
		return cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getSyllbusfileName() {
		return syllbusfileName;
	}

	public void setSyllbusfileName(String syllbusfileName) {
		this.syllbusfileName = syllbusfileName;
	}

	public byte[] getSyllbusfilePath() {
		return syllbusfilePath;
	}

	public void setSyllbusfilePath(byte[] syllbusfilePath) {
		this.syllbusfilePath = syllbusfilePath;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getcDuration() {
		return cDuration;
	}

}

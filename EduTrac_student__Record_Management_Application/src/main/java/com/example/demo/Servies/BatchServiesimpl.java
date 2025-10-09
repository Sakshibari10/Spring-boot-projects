package com.example.demo.Servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.Entity.Batches;
import com.example.demo.Exception.StudentException;
import com.example.demo.repositery.BatchRepo;

public class BatchServiesimpl implements BatchSevies {

	@Autowired
	BatchRepo batchRepo;

	@Override
	public void saveBatch(Batches batches) {

		if (batchRepo.existsById(batches.getB_Id())) {
			throw new StudentException("this id already exsit", HttpStatus.CONFLICT);
		}

		batchRepo.save(batches);

	}

	@Override
	public Batches getBatchbyId(int b_Id) {

		Batches batches = new Batches();

		if (batches.getB_Id() != b_Id) {
			throw new StudentException("batch not found by this id ", HttpStatus.BAD_REQUEST);
		}
		return batchRepo.findById(b_Id).get();

	}

	@Override
	public List<Batches> getAllBatchesForCourse(Long cId) {
		List<Batches> batches = batchRepo.findByCourseId(cId);
		if (batches.isEmpty()) {
			throw new StudentException("No batches found for course ID: " + cId, HttpStatus.BAD_REQUEST);
		}
		return batches;
	}

}

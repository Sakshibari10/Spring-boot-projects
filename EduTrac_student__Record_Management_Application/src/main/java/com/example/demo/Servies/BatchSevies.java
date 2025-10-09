package com.example.demo.Servies;

import java.util.List;

import com.example.demo.Entity.Batches;

public interface BatchSevies {

	void saveBatch(Batches batches);

	Batches getBatchbyId(int b_Id);

	public List<Batches> getAllBatchesForCourse(Long cId);

}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Batches;
import com.example.demo.Servies.BatchSevies;

@RestController
public class BatchController {

	@Autowired
	BatchSevies batchSevies;
	
	@PostMapping("/Batch")
	public ResponseEntity saveBatch(@RequestBody Batches batches)
	{
		batchSevies.saveBatch(batches);
		return new  ResponseEntity<>("batch is save", HttpStatus.OK);
	
	}
	
	@GetMapping("/Batch/{b_Id}")
	public ResponseEntity getbatchbyid(@PathVariable("b_Id") int b_Id)
	{
		
		return new ResponseEntity(batchSevies.getBatchbyId(b_Id),HttpStatus.OK);
		
	}
	
	@GetMapping("/Batch/{cId}")
	public ResponseEntity getbatchbyCoures(@PathVariable ("cId")  Long cId)
	{
		return new ResponseEntity(batchSevies.getAllBatchesForCourse(cId),HttpStatus.OK) ;
	}
}

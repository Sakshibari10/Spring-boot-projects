package com.example.demo.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Batches;

public interface BatchRepo extends JpaRepository<Batches, Integer> {

	List<Batches> findByCourseId(Long courseId);

}

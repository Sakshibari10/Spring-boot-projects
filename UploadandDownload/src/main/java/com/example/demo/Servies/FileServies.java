package com.example.demo.Servies;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.JavaFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repo.FileRepo;

import com.example.demo.entity.File;


@Service
public class FileServies {

	@Autowired
	FileRepo fileRepo;
	
	    public <S> void saveFile(MultipartFile file) throws IOException {
	        File files = new File();
	        files.setFile(files.getBytes());
	        fileRepo.saveAll(files);
	    }

	    public Object getFile(int fileId) {
	        return fileRepo.findById(fileId)
	                .orElseThrow(() -> new RuntimeException("File not found with ID: " + fileId));
	    }
	}




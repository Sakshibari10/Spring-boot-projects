package com.example.demo.Cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Servies.FileServies;
import com.example.demo.entity.File;

@RestController
public class FileController {

	@Autowired
	FileServies fileServies;
	
	@PostMapping("upload")
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file)
	{
		fileServies.saveFile(file);
		return new ResponseEntity("upload",HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/download/{fileId}")
	public ResponseEntity<Byte[]> downloadFile(@PathVariable("fileId") int fileId)
	{
	File file=	fileServies.getFile(fileId);
		
		return new ResponseEntity.ok().;
		
	}
}

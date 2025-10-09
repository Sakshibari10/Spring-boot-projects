package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Singup_Dto;
import com.example.demo.Entity.User;
import com.example.demo.Servies.UserServies;

@RestController
public class UserController {
@Autowired
UserServies userServies;

@PostMapping("/User")
public ResponseEntity savaData(@RequestBody User user)
{
	
	userServies.saveUser(user);
	return new ResponseEntity("data save",HttpStatus.ACCEPTED) ;
	}

@GetMapping("/user/{user_Id}")
public ResponseEntity getUser( @PathVariable("user_Id") int user_Id)
{
	  
	  return new ResponseEntity(userServies.getUser(user_Id),HttpStatus.OK) ;
}
	
@PostMapping("/Singup_user")
public ResponseEntity singupUser(@RequestBody Singup_Dto singup_Dto )
{
	
	 return new ResponseEntity(userServies.registerUser(singup_Dto),HttpStatus.CREATED) ;
	
	}

@PutMapping("user_update/{userId}")
public  ResponseEntity updateUser(@PathVariable("userId") int user_Id,@RequestBody User user)
{

	return new ResponseEntity( userServies.updateUser(user_Id, user ),HttpStatus.CONTINUE);
	
	}
}

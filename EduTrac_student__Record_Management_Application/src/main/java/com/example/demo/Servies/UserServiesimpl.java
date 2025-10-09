package com.example.demo.Servies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.AmititStudentManagmentApplication;
import com.example.demo.DTO.Singup_Dto;
import com.example.demo.Entity.User;
import com.example.demo.Exception.StudentException;
import com.example.demo.repositery.UserRepo;

@Service
public class UserServiesimpl implements UserServies {

 
    @Autowired
    private UserRepo userRepo;

    
    @Override
    public void saveUser(User user) {
    	
    	if(userRepo.existsById(user.getUser_Id()))
    	{
    		throw new StudentException("this id already exsit", HttpStatus.CONFLICT);
    	}
        userRepo.save(user);
    }
    
    @Override
    public User getUser(int user_Id) {
        
    	User user=new User();
  
	  
	  if(user.getUser_Id() != user_Id)
	  {
	  throw new StudentException(" user not found by this id ",HttpStatus.BAD_REQUEST);
	
	  }   
       
		return  userRepo.findById(user_Id).get() ;
    }
    
    @Override
    public List<User> getallUser() {
        return userRepo.findAll();
    }
    
    @Override
    public User registerUser(Singup_Dto singup_Dto) {
        // Check if email already exists
        if (userRepo.existsByEmail(singup_Dto.getEmail())) {
            throw new StudentException ("Email already exists: " ,HttpStatus.CONFLICT);
        }
        
        User user = new User();
        user.setUser_Name(singup_Dto.getUser_Name());
        user.setFirst_Name(singup_Dto.getFirst_Name());
        user.setLast_Name(singup_Dto.getLast_Name());
        user.setEmail(singup_Dto.getEmail());
        user.setPhone_No(singup_Dto.getPhone_No());
        user.setPassWord(singup_Dto.getPassWord());
        
        // Set default values for other fields if needed
        // user.setStatuS("ACTIVE"); // example default
        
        return userRepo.save(user);
    }
    
    @Override
    public User updateUser(int user_Id, User user) {
    	User existingUser = userRepo.findById(user_Id)
    		    .orElseThrow(() -> new StudentException("User not found with ID: " + user_Id, HttpStatus.BAD_REQUEST));

        // Update fields only if they are not null
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        
//   if ( user.getPhone_No() != null)
      
            existingUser.setPhone_No(user.getPhone_No());    
         
        if (user.getPassWord() != null) {
            existingUser.setPassWord(user.getPassWord());
        }
        if (user.getEduCation() != null) {
            existingUser.setEduCation(user.getEduCation());
        }
     
//        if (user.getPassout_Year() != null) {
            existingUser.setPassout_Year(user.getPassout_Year());
        
            existingUser.setStatuS("active");
        
        if (user.getParent_No() != null) {
            existingUser.setParent_No(user.getParent_No());
        }
        if (user.getaGe() > 0) {
            existingUser.setaGe(user.getaGe());
        }
    
        {
            existingUser.setGender(user.getGender());
        }
        if (user.getdOb() != null) {
            existingUser.setdOb(user.getdOb());
        }
        if (user.getAdhar_No() != null) {
            existingUser.setAdhar_No(user.getAdhar_No());
        }
//      
            existingUser.setvAn(user.getvAn());
        
        
        return userRepo.save(existingUser);
    }
}
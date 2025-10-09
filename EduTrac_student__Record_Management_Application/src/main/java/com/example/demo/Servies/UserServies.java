package com.example.demo.Servies;

import java.util.List;
import com.example.demo.DTO.Singup_Dto;
import com.example.demo.Entity.User;

public interface UserServies {
    
    void saveUser(User user);
    
    User getUser(int user_Id);
    
    List<User> getallUser();
    
    User registerUser(Singup_Dto singup_Dto);
    
    User updateUser(int user_Id, User user);
}
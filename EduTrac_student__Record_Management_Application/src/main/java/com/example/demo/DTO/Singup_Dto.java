package com.example.demo.DTO;

public class Singup_Dto {
    
    private String user_Name;
    private String first_Name;
    private String last_Name;
    private String email;
    private int phone_No;
    private String passWord;
    
    // Default constructor
    public Singup_Dto() {}
    
    // Constructor with all fields
    public Singup_Dto(String user_Name, String first_Name, String last_Name, 
                     String email, int phone_No, String passWord) {
        this.user_Name = user_Name;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.phone_No = phone_No;
        this.passWord = passWord;
    }
    
    // Getters and Setters
    public String getUser_Name() {
        return user_Name;
    }
    
    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }
    
    public String getFirst_Name() {
        return first_Name;
    }
    
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
    
    public String getLast_Name() {
        return last_Name;
    }
    
    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getPhone_No() {
        return phone_No;
    }
    
    public void setPhone_No(int phone_No) {
        this.phone_No = phone_No;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
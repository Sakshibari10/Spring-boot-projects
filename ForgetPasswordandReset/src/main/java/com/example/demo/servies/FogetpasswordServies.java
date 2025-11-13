package com.example.demo.servies;

import com.example.demo.entity.User;

public interface FogetpasswordServies {

	public User registerUser(User user);
	
	public String  resetPassword(String email , String newPassword);

	public String generateAndSendOtp(String email);
	
	String verifyOtp(String email, String enteredOtp  ) ;
	
	String resendOtp(String email);

    public String confirmPasswordReset(String email, String otp, String newPassword) ;

}

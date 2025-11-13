package com.example.demo.servies;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.Forgetrepo;
@Service
public class ForgetpasswordServiesimple implements FogetpasswordServies {

	@Autowired
private	Forgetrepo forgetrepo;

	@Autowired
	private JavaMailSender  mailSender;
	
	   @Autowired
	   private PasswordEncoder passwordEncoder;

	
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return forgetrepo.save(user);
	}

	
	public String generateAndSendOtp(String email)
	{
		
		User user = forgetrepo.findByEmail(email);
		if	(user == null)
			{
			return "User not found with this email";
			}
		
        // Generate 6-digit OTP

        String plainOtp = String.format("%06d", new Random().nextInt(999999));
		 String encryptedOtp = passwordEncoder.encode(plainOtp);
		 
		 user.setOtp(encryptedOtp);
		 user.setOtpExpriry(LocalDateTime.now().plusMinutes(5));
		 forgetrepo.save(user);
		 
	        // Send email
SimpleMailMessage message = new SimpleMailMessage();

message.setTo(email);
message.setSubject("password Reset Otp");
message.setText("your OTP is:"+ plainOtp + "\n valid for 5 minutes");
	mailSender.send(message);
	return "OTP sent successfully to \n"+ email;
		}
	
	@Override
	public String resetPassword(String email, String newPassword) {

	String otpMessage = generateAndSendOtp(email);
		
	
    return otpMessage + " Please verify OTP before resetting your password.";
	}

	@Override
	public String verifyOtp(String email, String enteredOtp) {

		User user = forgetrepo.findByEmail(email);
		if(user.getOtp()== null)
		
			return"Please request a new OTP";
			
		
		
		if(user.getOtpExpriry().isBefore(LocalDateTime.now()))
		  return "OTP expired! Request a new one";
		
        boolean match = passwordEncoder.matches(enteredOtp, user.getOtp());
		if(!match)
			return "Invalid oto";
        return "OTP verified successfully!";
	}

	@Override
	public String resendOtp(String email) {
		
		return generateAndSendOtp(email) ;
	}
	

    public String confirmPasswordReset(String email, String otp, String newPassword) 
    {
        User user = forgetrepo.findByEmail(email);

    	boolean match = passwordEncoder.matches(otp, user.getOtp());
    	if(!match)
    		return"Invalid OTP";
    	
    	user.setPassWord(passwordEncoder.encode(newPassword));
    	user.setOtp(null);
    	user.setOtpExpriry(null);
    	forgetrepo.save(user);
        return "Password reset successfully!";
    	
    }

	
	

}

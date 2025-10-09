package com.example.demo.Servies;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.StudentException;
import com.example.demo.repositery.UserRepo;

@Service
public class EmailServiesimpl implements EmailServies{

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override

	public String sendOtptotheEmail(String email) {
	    // ✅ Fetch the existing user
	    User user = userRepo.findByEmail(email)
	    	    .orElseThrow(() -> new StudentException("Email does not exist", HttpStatus.NOT_FOUND));

	 // ✅ Generate 6-digit OTP as String
	 String otp = String.format("%06d", new Random().nextInt(999_999));

	 // ✅ Update OTP fields
	 user.setSendOtp(otp);
	 user.setOtpCreatedAt(Instant.now());
	 user.setOtpUsed(false);

	    // ✅ Save changes to the same user
	    userRepo.save(user);

	    // Send email
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(email);
	    message.setSubject("Your OTP Code");
	    message.setText("Your OTP is: " + otp + "\nIt is valid for 10 minutes.");
	    javaMailSender.send(message);

	    return otp;
	}


	

	@Override
	public boolean verifyEmail(String email, String sendOtp) {
	    // 1️⃣ Find the user
	    User user = userRepo.findByEmail(email)
	            .orElseThrow(() -> new StudentException("Email not found", HttpStatus.NOT_FOUND));

	    // 2️⃣ Get OTP creation time
	    Instant otpGeneratedTime = user.getOtpCreatedAt();

	    if (otpGeneratedTime == null) {
	        throw new StudentException("OTP not generated", HttpStatus.BAD_REQUEST);
	    }

	    // 3️⃣ Check if OTP is expired
	    long currentTimeMillis = System.currentTimeMillis();
	    long otpTimeMillis = otpGeneratedTime.toEpochMilli();

	    long diffInMinutes = (currentTimeMillis - otpTimeMillis) / (60 * 1000);

	    if (diffInMinutes > 10) {
	        throw new StudentException("OTP expired", HttpStatus.REQUEST_TIMEOUT);
	    }

	    // 4️⃣ Check if OTP is already used
	    if (Boolean.TRUE.equals(user.getSendOtp())) {
	        throw new StudentException("OTP already used", HttpStatus.BAD_REQUEST);
	    }

	    // 5️⃣ Compare OTP values
	    if (!sendOtp.equals(user.getSendOtp())) {
	        throw new StudentException("Invalid OTP", HttpStatus.BAD_REQUEST);
	    }

	    // 6️⃣ Mark as used and save
	    user.setOtpUsed(true);
	    userRepo.save(user);

	    return true;
	}




//	@Override
//	public boolean verifyEmail(String email, int SendOtp) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//

	
}

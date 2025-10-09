package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Servies.EmailServies;

@RestController
public class EmailController {
	
	  @Autowired
	    EmailServies emailServies;

	    @PostMapping("/send-otp")
	    public ResponseEntity<String> sendEmail(@RequestBody Map<String, String> request) {
	        String email = request.get("email");
	        return new ResponseEntity<>(emailServies.sendOtptotheEmail(email), HttpStatus.OK);
	    }
	
	    @PostMapping("/verify")
	    public ResponseEntity<String> verifyEmail(@RequestBody Map<String, Object> request) {
	        String email = (String) request.get("email");
	        String sendOtp = String.valueOf(request.get("sendOtp"));

	        boolean isVerified = emailServies.verifyEmail(email, sendOtp);
	        if (isVerified) {
	            return ResponseEntity.ok("Email verified successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
	        }
	    }

	}

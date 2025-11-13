package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.servies.FogetpasswordServies;

@RestController
@RequestMapping("/api/users")
public class ForgetpasswordController {

	@Autowired
	private FogetpasswordServies fogetpasswordServies;
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return fogetpasswordServies.registerUser(user) ;
		}
    

	@PostMapping("/forgot-password")
   public String forgetPassword(@RequestParam String email)
   {
	   
	   return fogetpasswordServies.generateAndSendOtp(email);
   }
	 
	  @PostMapping("/verify-otp")
	    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
	        return fogetpasswordServies.verifyOtp(email, otp);
	    }

	    @PostMapping("/resend-otp")
	    public String resendOtp(@RequestParam String email) {
	        return fogetpasswordServies.resendOtp(email);
	    }

	    @PostMapping("/reset-password")
	    public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
	        return fogetpasswordServies.resetPassword(email, newPassword);
	    }

	    @PostMapping("/confirm-reset")
	    public String confirmPasswordReset(@RequestParam String email,
	                                       @RequestParam String otp,
	                                       @RequestParam String newPassword) {
	        return fogetpasswordServies.confirmPasswordReset(email, otp, newPassword);
	    }

	
   }
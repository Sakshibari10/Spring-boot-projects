package com.example.demo.config;


	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.web.SecurityFilterChain;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;

	@Configuration
	public class Securityconfig {

	    // ✅ Step 1: Register PasswordEncoder bean
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    // ✅ Step 2: Disable login popup, make all APIs public
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // disable CSRF for testing / browser POST
	            .authorizeHttpRequests()
	                .anyRequest().permitAll() // allow all endpoints
	            .and()
	            .formLogin().disable() // disable default login page
	            .httpBasic().disable(); // disable popup username/password

	        return http.build();
	    }
	}



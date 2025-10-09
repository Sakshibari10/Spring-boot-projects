package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.User;
import java.util.List;
import java.util.Optional;


@Repository

    
	public interface UserRepo extends JpaRepository<User, Integer> {
	    boolean existsByEmail(String email);
	    Optional<User> findByEmail(String email);

  
   
}
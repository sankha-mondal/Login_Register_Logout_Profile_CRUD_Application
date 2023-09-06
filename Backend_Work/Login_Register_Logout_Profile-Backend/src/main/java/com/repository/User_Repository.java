package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.User;


@Repository
public interface User_Repository extends JpaRepository<User, String> {
	
	public User findByuNameIgnoreCase(String uName);  // Op: 2B
	public List<User> findByuGenderIgnoreCase(String uGender);  // Op: 2C

}


package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;


@Repository
public interface User_Repository extends JpaRepository<User, String> {
	
	//  Retrieve data by Email & Password Operation:-  Op: 5
	
//	@Query("select p from Passenger p where p.pEmail = :pEmail and p.pPassword = :pPassword")
//	public int findPassengerByEmail_Pass(@Param("pEmail") String pEmail,@Param("pPassword") String pPassword);

}


package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Passenger;


@Repository
public interface Passenger_Repository extends JpaRepository<Passenger, String> {
	
	//  Retrieve data by Email & Password Operation:-  Op: 5
	
//	@Query("select p from Passenger p where p.pEmail = :pEmail and p.pPassword = :pPassword")
//	public int findPassengerByEmail_Pass(@Param("pEmail") String pEmail,@Param("pPassword") String pPassword);

}


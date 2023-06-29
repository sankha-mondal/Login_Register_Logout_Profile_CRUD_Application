package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import com.entity.Passenger;
import com.repository.Passenger_Repository;


@Service
public class Passenger_Service {
	
	@Autowired
	Passenger_Repository passengerRepo;
	
	
// ======================================================================================================================
	
	//  Insert Operation by Id-Unique Email:-    Op:3
	
	public String storePassenger(Passenger passenger) {
		boolean res = passengerRepo.existsById(passenger.getpEmail());
		System.out.println(res);
		if(res) {
			return "Passenger details didn't store...\nYou have already Registered...";
		}
		else {
			passengerRepo.save(passenger);
			return "Passenger("+ passenger.getpName() +") Registered successfully...";
		}
	}	
	
	
// =====================================================================================================================
	
			//  Retrieve Message by Email & password | Login Operation :-   Op: 7
	
			public String findPassengerByEmail_Pass(Passenger passenger) {
				String email = passenger.getpEmail();
				String password = passenger.getpPassword();
				
				Optional<Passenger> op = passengerRepo.findById(passenger.getpEmail());
				System.out.println("**************************"+op);
				
					if(op.isPresent()) {
						Passenger p = op.get();
						
						if(p.getpPassword().equals(passenger.getpPassword())) {
							return "WELCOME";
						} else {
							return "Password may be worng";
						}
					} else {
						return "Email or Password may be worng";
					}
			}

// ====================================================================================================================
// ====================================================================================================================
			

}

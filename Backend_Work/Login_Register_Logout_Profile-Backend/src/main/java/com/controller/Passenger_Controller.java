package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Passenger;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.Passenger_Repository;
import com.service.Passenger_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/passenger")		//  http://localhost:8585/passenger
public class Passenger_Controller {
	
	@Autowired
	Passenger_Repository passengerRepo;
	
	@Autowired
	Passenger_Service passengerService;
	
	
//*************************************************** : CRUD Operation : *****************************************************************	  
//=======================================================================================================================================

	  	 //  Retrieve Operation:-  Op:1
	  
	  	 //	 http://localhost:8585/passenger/getAll
	  
		  @GetMapping("/getAll")
		  public ResponseEntity<List<Passenger>> getAllPassenger() {
		    List<Passenger> passenger = new ArrayList<Passenger>();
		
		    	passengerRepo.findAll().forEach(passenger::add);
			
			    if (passenger.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			
			    return new ResponseEntity<>(passenger, HttpStatus.OK);
		  }
		  
	  
	  
//=======================================================================================================================================

		  //  Retrieve data by Passenger-Email :-  Op:2
		  
		  //  http://localhost:8585/passenger/getPassByEmail/{pEmail}

		  @GetMapping("/getPassByEmail/{pEmail}")
		  public ResponseEntity<Passenger> getPassByEmail(@PathVariable("pEmail") String pEmail) {
			  
			  Passenger passenger = passengerRepo.findById(pEmail)
					  .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
		
		    	return new ResponseEntity<>(passenger, HttpStatus.OK);
		  }
		  
	  
	  
//=======================================================================================================================================
		  
		  //  Insert Operation:-    Op:3
		  
		  //  http://localhost:8585/passenger/store
		  
//		  @PostMapping("/store")
//		  public ResponseEntity<Passenger> storePassenger(@RequestBody Passenger passReq) { 
//			  Passenger _passenger = passengerRepo.save(new Passenger(passReq.getpEmail(),
//					  												  passReq.getpName(), 
//					  												  passReq.getpPhone(),
//					  												  passReq.getpPassword(),
//					  												  passReq.getpRole(),
//					  												  passReq.getpAddress(),					  												    
//					  												  passReq.getUrl(),
//					  												  passReq.getBooking()
//					  												  ));
//			  					
//		    return new ResponseEntity<>(_passenger, HttpStatus.CREATED);
//		  }
		  
		  @PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
		  public String storePassenger(@RequestBody Passenger passenger) {
			  System.out.println(passenger.getpEmail());
			  
			  return passengerService.storePassenger(passenger);
		  }
		  
	  
	  
//=======================================================================================================================================  

		  //  Update Operation:-   Op:4
		  
		  //  http://localhost:8585/passenger/update/{pEmail}
		  
		  @PutMapping("/update/{pEmail}")
		  public ResponseEntity<Passenger> updatePassenger(@PathVariable("pEmail") String pEmail, 
				  										   @RequestBody Passenger passReq) {
			  
			  Passenger _passenger = passengerRepo.findById(pEmail)
					  .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
		
			    _passenger.setpAddress(passReq.getpAddress());
			    _passenger.setpName(passReq.getpName());
			    _passenger.setpPassword(passReq.getpPassword());
			    _passenger.setpPhone(passReq.getpPhone());
			    _passenger.setpRole(passReq.getpRole());
			    _passenger.setUrl(passReq.getUrl());
			//  _passenger.setBooking(passReq.getBooking());  // Don't do this bcoz it will store null at the time of Update. 
			    
		    return new ResponseEntity<>(passengerRepo.save(_passenger), HttpStatus.OK);
		  }
		  
		  
	  
//=======================================================================================================================================
		  
		  //  Delete Operation by Id:-   Op:5
		  
		  //  http://localhost:8585/passenger/delete/{pEmail}
		  
		  @DeleteMapping("/delete/{pEmail}")
		  public ResponseEntity<ApiResponse> deletePassenger(@PathVariable("pEmail") String pEmail) {
			  
			  Passenger pass_email = passengerRepo.findById(pEmail)
				        .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
			  
			  passengerRepo.deleteById(pEmail);
		    
		    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  return new ResponseEntity<ApiResponse>(new ApiResponse("Passenger details deleted Successfully", true), HttpStatus.OK);
		  }
		  
		  
	  
//=======================================================================================================================================
		  
		  //  All Delete Operation:-   Op:6
			 
		  //  http://localhost:8585/passenger/deleteAll

		  @DeleteMapping("/deleteAll")
		  public ResponseEntity<HttpStatus> deleteAllPassenger() {
			  
			  passengerRepo.deleteAll();
		    
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	  
		  
		  
//=======================================================================================================================================
//**************************************************** : User Define : *****************************************************************		  
//======================================================================================================================================
		  		  
			//  Retrieve Message by Email & password | Login Operation :-   Op: 7
			
			//  http://localhost:8585/passenger/findPassengerByEmail_Password
		  
			@PostMapping(value = "findPassengerByEmail_Password")
			public String findPassengerByEmail_Pass(@RequestBody Passenger passenger) {
				
				System.out.println("Controller: "+passenger.getpEmail());
				//Thread.sleep(3000);
				return passengerService.findPassengerByEmail_Pass(passenger);
			}
		  
			
// =================================================================================================================	  
// =================================================================================================================	  

		  
		 
		  
}

package com.controller;

import java.util.*;

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
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.User_Repository;
import com.service.User_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user") //  http://localhost:8585/users_credentials/user

public class User_Controller {

	@Autowired
	User_Repository userRepo;

	@Autowired
	User_Service userService;  

//*************************************************** : CRUD Operation : ***************************************************************** 
//========================================================================================================================================

		//  Simple Get Operation:- Op:A
		//  http://localhost:8585/users_credentials/user/hello_world
	
		@GetMapping("/hello_world")
		public String hello_world() {
			return "Hello World";
		}
	
	
		//  Simple Get Operation:- Op:B
		//  http://localhost:8585/users_credentials/user/get_data
	
		@GetMapping("/get_data")
		public Map<String, String> getData() {
			return Map.of("Name","Sankha Subhra");
		}

		//  Retrieve Operation:-  Op:C
		// http://localhost:8585/users_credentials/user/get_Json
		
		@RequestMapping("/get_Json")
		public List<User> getJson() {
			return Arrays.asList(
					new User("rabi@gmail.com", "Rabi", "9876543219", "R123", "MALE", "USER", "Kolkata", "rrr"),
					new User("ajay@gmail.com", "Ajay", "8978675453", "A123", "MALE", "USER", "Babgalore", "aaa"),
					new User("hasr@gmail.com", "Hars", "7865093748", "H123", "MALE", "USER", "Mumbai", "ppp")
					);
					
		}
	
//=======================================================================================================================================

		//  Retrieve Operation:-  Op:1
		//  http://localhost:8585/users_credentials/user/getAll

		@GetMapping("/getAll")
		public ResponseEntity<List<User>> getAllUser() {

				List<User> user = new ArrayList<User>();
				userRepo.findAll().forEach(user::add);
	
				if (user.isEmpty()) {
					// return new ResponseEntity<>(HttpStatus.NO_CONTENT);  OR
					throw new ResourceNotFoundException("No Data Found..");
				}

			return new ResponseEntity<>(user, HttpStatus.OK);
		}

//=======================================================================================================================================

		//  Retrieve data by User-Email :-  Op:2
		//  http://localhost:8585/users_credentials/user/getUserByEmail/{uEmail}

		@GetMapping("/getUserByEmail/{uEmail}")
		public ResponseEntity<User> getPassByEmail(@PathVariable("uEmail") String uEmail) {

			User user = userRepo.findById(uEmail)
					.orElseThrow(() -> new ResourceNotFoundException("Not found User with Email = " + uEmail));

			return new ResponseEntity<>(user, HttpStatus.OK);
		} 

//=======================================================================================================================================

		//  Insert Operation:-    Op:3
		//  http://localhost:8585/users_credentials/user/store
		
		//   @PostMapping("/store")
		//   public ResponseEntity<Passenger> storePassenger(@RequestBody Passenger passReq) {
		//   		Passenger _passenger = passengerRepo.save(new Passenger(passReq.getpEmail(),
		//     																passReq.getpName(),
		//     																passReq.getpPhone(),
		//     																passReq.getpPassword(),
		//															        passReq.getpRole(),
		//                                                                  passReq.getpAddress(),      
		//                                                                  passReq.getUrl(),
		//                                                                  passReq.getBooking()
		//															        ));
		//   
		//	        return new ResponseEntity<>(_passenger, HttpStatus.CREATED);
		//   }

		@PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String storePassenger(@RequestBody User user) {
			System.out.println(user.getuEmail());

			return userService.storeUser(user);
		}

//=======================================================================================================================================

		//  Update Operation:-   Op:4
		//  http://localhost:8585/users_credentials/user/update/{uEmail}

		@PutMapping("/update/{uEmail}")
		public ResponseEntity<User> updateUser(@PathVariable("uEmail") String uEmail,
						       @RequestBody User userReq) {

			User _user = userRepo.findById(uEmail)
					.orElseThrow(() -> new ResourceNotFoundException("Not found User with Email = " + uEmail));

					_user.setuAddress(userReq.getuAddress());
					_user.setuName(userReq.getuName());
					_user.setuPassword(userReq.getuPassword());
					_user.setuPhone(userReq.getuPhone());
					_user.setuGender(userReq.getuGender());
					_user.setuRole(userReq.getuRole());
					_user.setUrl(userReq.getUrl());
				//  _user.setBooking(userReq.getBooking());  // Don't do this bcoz it will store null at the time of Update.

			return new ResponseEntity<>(userRepo.save(_user), HttpStatus.OK);
		}

//=======================================================================================================================================

		//  Delete Operation by Id:-   Op:5
		//  http://localhost:8585/users_credentials/user/delete/{uEmail}

		@DeleteMapping("/delete/{uEmail}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable("uEmail") String uEmail) {

				User user_email = userRepo.findById(uEmail)
						.orElseThrow(() -> new ResourceNotFoundException("Not found User with Email = " + uEmail));

				userRepo.deleteById(uEmail);

			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			   return new ResponseEntity<ApiResponse>(new ApiResponse("User details deleted Successfully", true), HttpStatus.OK);
		}

//=======================================================================================================================================

		//  All Delete Operation:-   Op:6
		//  http://localhost:8585/users_credentials/user/deleteAll

		@DeleteMapping("/deleteAll")
		public ResponseEntity<HttpStatus> deleteAllUser() {

				userRepo.deleteAll();
    
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

 

//======================================================================================================================================
//**************************************************** : User Define : ***************************************************************** 
//======================================================================================================================================

		//  Retrieve Message by Email & password | Login Operation :-   Op: 7
		//  http://localhost:8585/users_credentials/user/login

		@PostMapping(value = "login")
		public String find_UserByEmailPassword(@RequestBody User user) {

				System.out.println("Controller: "+user.getuEmail());
				//Thread.sleep(3000);
				return userService.find_UserByEmailPassword(user);
		}


//=====================================================================================================================================
//=====================================================================================================================================

}

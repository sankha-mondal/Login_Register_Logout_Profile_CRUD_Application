package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.entity.User;
import com.repository.User_Repository;

@Service

public class User_Service {

	@Autowired
	User_Repository userRepo;

// ======================================================================================================================

		//  Insert Operation by Id-Unique Email:-    Op:3

		public String storeUser(User user) {
			boolean res = userRepo.existsById(user.getuEmail());
			System.out.println(res);

			if(res) {
				return "User details didn't store...\nYou have already Registered...";
			}
			else {
				userRepo.save(user);
				return "User("+ user.getuName() +") Registered successfully...";
			}
		}

// =====================================================================================================================

		//  Retrieve Message by Email & password | Login Operation :-   Op: 7

		public String find_UserByEmailPassword(User user) {

			String email = user.getuEmail();
			String password = user.getuPassword();

			Optional<User> op = userRepo.findById(email);
			System.out.println("**************************"+op);

			if(op.isPresent()) {
				User p = op.get();
				if(p.getuPassword().equals(password)) {
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

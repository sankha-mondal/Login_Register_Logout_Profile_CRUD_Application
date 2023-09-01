package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helper_classes.Email_Details;
import com.service.Email_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/email")       //  http://localhost:8585/users_credentials/email
public class Email_Controller {

	@Autowired private Email_Service emailService;
	
//  =================================================================================================================================

	// Sending a simple Email
	// http://localhost:8585/users_credentials/email/sendMail
	
	@PostMapping("/sendMail")
	public String
	sendMail(@RequestBody Email_Details emailDetails) throws InterruptedException {
		
		String status = emailService.sendSimpleMail(emailDetails);
			return status;
	}
	
//  =================================================================================================================================

	// Sending email with attachment
	// http://localhost:8585/users_credentials/email/sendMailWithAttachment
	
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody Email_Details emailDetails) throws InterruptedException {
		 
		System.out.println("Recipient Email: "+emailDetails.getRecipient());
		String status= emailService.sendMailWithAttachment(emailDetails);
		    return status;
	}
	
//  =================================================================================================
	
}


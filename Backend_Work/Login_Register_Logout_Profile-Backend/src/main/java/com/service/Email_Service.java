package com.service;

import com.helper_classes.Email_Details;

//Java Program to Illustrate Creation Of
//Service Interface



//Interface
public interface Email_Service {

	// Method
	// To send a simple email
	String sendSimpleMail(Email_Details emailDetails);

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(Email_Details emaildetails);
}


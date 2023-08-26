package com.service.impl;

import com.helper_classes.Email_Details;
import com.service.Email_Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

//Annotation
@Service
//Class Implementing EmailService interface
public class Email_Service_Impl implements Email_Service {

	@Autowired private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") private String sender;

	// Method 1
	// To send a simple email
	@Override
	public String sendSimpleMail(Email_Details emailDetails)
	{

		try {
			
			// Creating a simple mail message
			SimpleMailMessage mailMessage
				= new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setText(emailDetails.getMsgBody());
			mailMessage.setSubject(emailDetails.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			return "Error while sending mail..!!!\nTurn on your Internet...";
		}
	}

	// Method 2
	// To send an email with attachment
	@Override
	public String sendMailWithAttachment(Email_Details emailDetails)
	{
		MimeMessage mimeMessage
			= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to be send
			mimeMessageHelper
				= new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getRecipient());
			mimeMessageHelper.setText(emailDetails.getMsgBody());
			mimeMessageHelper.setSubject(emailDetails.getSubject());

			// Adding the attachment  for Windows
//			FileSystemResource file
//				= new FileSystemResource(
//					new File(emailDetails.getAttachment()));
			
			// Adding the attachment for MAC 
			FileSystemResource file
				= new FileSystemResource(
					new File(StringUtils.cleanPath(emailDetails.getAttachment())));
			
			System.out.println("File Path: "+emailDetails.getAttachment());
			System.out.println("File name: "+file.getFilename());
			
			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			
			System.out.println("Recipient Email: "+emailDetails.getRecipient());
			return "Mail sent Successfully...";
		}
		catch (MessagingException e) {

			return "Error while sending mail..!!!\n";
		}
	}
}


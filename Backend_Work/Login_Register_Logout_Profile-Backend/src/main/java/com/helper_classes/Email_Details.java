package com.helper_classes;

//Class
public class Email_Details {
	
	// Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
    
    /*  For MAC:
        {
    	"recipient": "iamsankha20@gmail.com",
    	"subject": "Project || Ship Reservation System",
    	"msgBody": "Hey,\n This is your Booking Details.\nHave a nice day.",
    	"attachment": "/Users/sankhasubhramondal/Capstone/SRS.pdf"
		}
		
		For Windows:: 
		{
    	"recipient": "iamsankha20@gmail.com",
    	"subject": "Project || Ship Reservation System",
    	"msgBody": "Hey,\n This is your Booking Details.\nHave a nice day.",
    	"attachment": "/F:/GIT/Help/Git_Tutorial.pdf"
		}
     */
    
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	@Override
	public String toString() {
		return "Email_Details [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject
				+ ", attachment=" + attachment + "]";
	}
	
	public Email_Details(String recipient, String msgBody, String subject, String attachment) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
		this.attachment = attachment;
	}
	
	public Email_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    

}

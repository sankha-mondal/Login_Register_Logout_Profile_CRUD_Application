package com.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Passenger")
public class Passenger {    //  Passenger = Login-Credentials
	
	
	@Id
	@Column(name="pEmail", unique=true)
	private String pEmail;
	
	@Column(name="pName")
	private String pName;
	
	@Column(name="pPhone")
	private String pPhone;
	
	@Column(name="pPassword")
	private String pPassword;
	
	@Column(name="pRole")
	private String pRole;
	
	@Column(name="pAddress")
	private String pAddress;
	
	@Column(name="url")
	private String url;

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getpPassword() {
		return pPassword;
	}

	public void setpPassword(String pPassword) {
		this.pPassword = pPassword;
	}

	public String getpRole() {
		return pRole;
	}

	public void setpRole(String pRole) {
		this.pRole = pRole;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Passenger [pEmail=" + pEmail + ", pName=" + pName + ", pPhone=" + pPhone + ", pPassword=" + pPassword
				+ ", pRole=" + pRole + ", pAddress=" + pAddress + ", url=" + url + "]";
	}

	public Passenger(String pEmail, String pName, String pPhone, String pPassword, String pRole, String pAddress,
			String url) {
		super();
		this.pEmail = pEmail;
		this.pName = pName;
		this.pPhone = pPhone;
		this.pPassword = pPassword;
		this.pRole = pRole;
		this.pAddress = pAddress;
		this.url = url;
	}

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



}



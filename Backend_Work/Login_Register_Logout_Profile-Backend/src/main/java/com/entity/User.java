package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {    //  User = Login-Credentials


    @Id
    @Column(name="uEmail", unique=true)
    private String uEmail;

    @Column(name="uName")
    private String uName;

    @Column(name="uPhone")
    private String uPhone;

    @Column(name="uPassword")
    private String uPassword;

    @Column(name = "uGender")
    private String uGender;

    @Column(name="uRole")
    private String uRole;

    @Column(name="uAddress")
    private String uAddress;

    @Column(name="url")
    private String url;

    /*
         {
            "uEmail" : "sankha@gmail.com",
            "uName" : "Sankha Subhra",
            "uPhone" : "9876543284",
            "uPassword" : "Sankha@123",
            "uGender" : "MALE",
            "uRole" : "USER",
            "uAddress" : "Kolkata",
            "url" : "profile img"
        }
     */

 

    public String getuEmail() {
        return uEmail;
    }

 

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

 

    public String getuName() {
        return uName;
    }

 

    public void setuName(String uName) {
        this.uName = uName;
    }

 

    public String getuPhone() {
        return uPhone;
    }

 

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

 

    public String getuPassword() {
        return uPassword;
    }

 

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

 

    public String getuGender() {
        return uGender;
    }

 

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

 

    public String getuRole() {
        return uRole;
    }

 

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

 

    public String getuAddress() {
        return uAddress;
    }

 

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

 

    public String getUrl() {
        return url;
    }

 

    public void setUrl(String url) {
        this.url = url;
    }

 

    @Override
    public String toString() {
        return "User [uEmail=" + uEmail + ", uName=" + uName + ", uPhone=" + uPhone + ", uPassword=" + uPassword
                + ", uGender=" + uGender + ", uRole=" + uRole + ", uAddress=" + uAddress + ", url=" + url + "]";
    }

 

    public User(String uEmail, String uName, String uPhone, String uPassword, String uGender, String uRole,
            String uAddress, String url) {
        super();
        this.uEmail = uEmail;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uPassword = uPassword;
        this.uGender = uGender;
        this.uRole = uRole;
        this.uAddress = uAddress;
        this.url = url;
    }

 

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


}

 

 

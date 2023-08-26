import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'src/app/Interfaces/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: Array<User> = [];   // user array memory created..

  booking: any;

  deleteMsg: string = "";
  updateMsg: string = "";
  storeMsg: string = "";

  uEmail: string = "";
  uName: string = "";
  uPhone: string = "";
  uPassword: string = "";
  uRole: string = "";
  uAddress: string = "";
  url: string = "";

  bookingId: string = "";
  paymentAmount: number = 0;
  bookingDate: any;

  flag_cred: number = 0;
  flag_login: number = 0;

  new_password: string = "";
  confirm_password: string = "";

  searchText: any;
  checkPswd: string = "";
  styProperty1 = { 'display': '' };
  styProperty2 = { 'display': '' };

  constructor(private us: UserService,
              private routen: Router,
              private titleService: Title) {
                  this.titleService.setTitle("Profile page");
  }

  ngOnInit(): void {
    this.get_All_User();
    // this.getAll_Booking();
  }

// ================================================ :Retrieve Passenger Operation: =============================================

  get_All_User(): void {
    this.us.getAll_User().subscribe(result => {
      this.user = result;
      console.log("All data comming for profile compo...")
      console.log(result);   // details for all users
      // this.get_record_for_Update_Delete();
    })
  }

// =========================================== :Update Passenger Profile Operation: ==============================================

  get_record_for_Update_Delete(passwordRef_update: NgForm) {
    let email = sessionStorage.getItem("email_session");
    console.log(passwordRef_update.value);
    let old_password = passwordRef_update.value.checkPswd;
    console.log("Old Password: " + old_password)

    for (let i = 0; i < this.user.length; i++) {
      //   console.log(this.users);
      if (this.user[i].uEmail == email && this.user[i].uPassword == old_password) {
        console.log("Email getting for particular person " + email);
        console.log("Password getting for particular person " + old_password);
        this.uEmail = email;
        this.uName = this.user[i].uName;
        this.uPhone = this.user[i].uPhone;
        this.uPassword = this.user[i].uPassword;
        // this.new_password = this.passenger[i].pPassword;  // for checking old to new password
        this.uRole = this.user[i].uRole;
        this.uAddress = this.user[i].uAddress;
        this.url = this.user[i].url;
        this.flag_cred = 1
        this.flag_login = 1;
        this.styProperty1 = { 'display': 'none' };
      }
    }

    if (this.flag_login == 0) {
      if (email == null) {
        alert("Do Login First...")
        this.routen.navigate([""], { skipLocationChange: true });
      }
      else {
        alert("Put Your Correct password..!!")
      }
    }
    sessionStorage.setItem("profile_name_session", this.uName);
    // let email = sessionStorage.getItem("email_session");
    console.log("Get Booking for one email " + email);

    if (email == "admin@ad.com") {
      this.styProperty2 = { 'display': 'none' };
    }
    else {
      // this.get_Booking_ByEmail();
    }
  }


  update_User_In_Db(userRef_update: NgForm) {

    let new_pass = userRef_update.value.new_password;
    console.log("New Password: " + new_pass);
    let confirm_pass = userRef_update.value.confirm_password;
    console.log("Confirm Password: " + confirm_pass);
    let uName = sessionStorage.getItem("name_session");

    if (this.uPassword != new_pass) {
      if (new_pass == confirm_pass) {

        let user = {
          uEmail: this.uEmail,
          uName: this.uName,
          uPhone: this.uPhone,
          uPassword: this.confirm_password,
          uRole: this.uRole,
          uAddress: this.uAddress,
          url: this.url
        }

        this.us.update_User(this.uEmail, user).subscribe(result => {
          this.updateMsg = result;
          sessionStorage.removeItem("password_session");
          sessionStorage.setItem("password_session", this.new_password);
          console.log("Update Successfully...");
          alert("Password Updated Successfully...\nHave a nice day...");
          if (this.uEmail == "admin@ad.com") {
            this.routen.navigate(["admin/home"], { skipLocationChange: true });
          }
          else {
            this.routen.navigate(["user/home", uName], { skipLocationChange: true });
          }
        }, error => console.log(error)
        )
      } else {
        alert("Your New Password and Confirm Password must be same...")
      }
    }
    else {
      alert("Your New Password and Old Password are same...\nTry with another to Update your Password...")
    }
  }

//=================================================== : Delete Operation : ======================================================

  delete_User(): void {
    let user = {
      uEmail: this.uEmail
    }

    if (confirm("Are you sure..!?")) {
      this.us.delete_User(this.uEmail).subscribe(result => {
        this.deleteMsg = result;
        console.log("Profile deleted..");
        alert("Your Profile removed Successfully..");
        window.location.reload();
      }, error => console.log(error), () => {
        sessionStorage.removeItem("email_session");
        sessionStorage.removeItem("password_session");
        this.routen.navigate([""]);
      })
    }
  }

// =================================================================================================================================
// =================================================================================================================================







}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email_store: string = "";
  password_store: string = "";
  uEmail: any;
  uPassword: string = "";

  user: any;

  uName: string = "";
  uPhone: string = "";
  uRole: string = "";
  uAddress: string = "";
  url: string = "";

  constructor(private us: UserService,
              private router: Router,
              private titleService: Title) {
                  this.titleService.setTitle("Login Page");
  }

  ngOnInit(): void {
  }

//================================================== Template DForm =======================================================

  loginUser(loginRef: NgForm) {
    let login = loginRef.value;
    console.log(login);
    console.log(login.uEmail);
    console.log(login.uPassword);

    this.us.login(login).subscribe(
      result => {
        if (result == "WELCOME") {
          sessionStorage.setItem("email_session", login.uEmail);
          sessionStorage.setItem("password_session", login.uPassword);
          if (login.uEmail == "admin@ad.com") {      //  && login.password=="admin"
            this.getOne_User();
            this.router.navigate(["admin/home"], { skipLocationChange: true });
          } else {
            console.log("Logged in..")
            alert("Welcome " + login.uEmail);
            this.getOne_User();
            this.router.navigate(["user/home", login.uEmail], { skipLocationChange: true });
          }
        } else {
          alert(result);
        }

      }, error => {
        console.log(error);
        console.log("null " + login.email);
      }
    )
  }

// ===========================================  Get Role & Name: Admin or Passenger  ====================================
// ==============================================  Get One-Passenger By Email:PK  =======================================

  getOne_User(): void {
    let email = sessionStorage.getItem("email_session");
    this.uEmail = email;
    console.log(email);

    this.us.getOne_User(this.uEmail).subscribe(
      result => {
        console.log(result);
        sessionStorage.setItem("name_session", result.uName);
        sessionStorage.setItem("role_session", result.uRole);
      }, error => console.log(error)
    )
  }

// =====================================================================================================================

  goto_register_page(): void {
    this.router.navigate(["/register"], { skipLocationChange: true });
  }

  goto_forgot_passwprd_page(): void {
    this.router.navigate(["/forgot-password"], { skipLocationChange: true });
  }

// ====================================================================================================================
// ====================================================================================================================



}


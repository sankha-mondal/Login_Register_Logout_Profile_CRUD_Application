import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  root = '/';
  f_login: boolean = false;  // realtime
  f_reg: boolean = false;    // realtime
  f_logout: boolean = true;  // realtime
  f_reg_cons: boolean = true;
  // email: any;
  flag_admin: boolean = true;
  flag_passenger: boolean = true;

  hr: any = 0;
  min: any = 30;
  sec: any = 60;

  constructor(private router: Router) { }

  ngOnInit(): void {
    // this.email = sessionStorage.getItem("email_session");
    this.login_disable_2nd();
    sessionStorage.setItem("count_time", "start");     
    this.countdown_sec();
    this.countdown_min();
    this.countdown_hr();
  }

 

  // =====================  Logout Operation  ========================

  logout() {
    this.f_login = false;
    this.f_reg = false;
    this.f_logout = true;
    this.flag_admin = true;
    this.flag_passenger = true;
    sessionStorage.removeItem("email_session");
    sessionStorage.removeItem("password_session");
    sessionStorage.removeItem("profile_name_session");
    sessionStorage.removeItem("name_session");
    sessionStorage.removeItem("role_session");
    sessionStorage.removeItem("fi_sec");
    sessionStorage.removeItem("fi_min");
    sessionStorage.removeItem("fi_hr");
    sessionStorage.removeItem("count_time");
    this.refresh_page();
    this.router.navigate([""]);
  }

   // ==================  Login btn Operations  =======================

  login_disable_1st() {
      this.f_login = true;
      this.f_reg = true;
      this.f_logout = false;
      // this.toggle();  not required
  }

  login_disable_2nd() {      //  works at the time on page refreshing
    // sessionStorage.setItem("email_session", "dummy@dummy.com");
    let email = sessionStorage.getItem("email_session");
    if(email != null) {
      this.f_login = true;
      this.f_reg = true;
      this.f_logout = false;
      this.toggle();
    }
  }

  logout_disable() {
    this.f_login = false;
    this.f_reg = false;
    this.f_logout = true;
  }

  toggle() {
    let role = sessionStorage.getItem("role_session");
    console.log("********"+role);
    if(role == "ADMIN") {
        this.flag_admin = false;
        this.flag_passenger = true;
    }
    else if(role == "USER")  {
        this.flag_passenger = false;
        this.flag_admin = true;
    }
  }

//  ============================================================================================================

    admin_home_page(): void {
      this.router.navigate(["admin/home"], {skipLocationChange:true});
    }

    passenger_home_page(): void {
      let uName = sessionStorage.getItem("name_session");
      this.router.navigate(["user/home", uName], {skipLocationChange:true});
    }

    goto_login_page(): void {
      this.router.navigate(["login"], {skipLocationChange:true});
    }

    goto_register_page(): void {
      this.router.navigate(["register"], {skipLocationChange:true});
    }

    goto_profile_page(): void {
      this.router.navigate(["profile"], {skipLocationChange:true});
    }

    goto_aboutUs_page(): void {
      this.router.navigate(["about_us"], {skipLocationChange:true});
    }

    goto_home_page(): void {
      this.toggle();
      this.router.navigate([""], {skipLocationChange:true});
    }

//  ============================================================================================================

  countdown_sec() {
    setInterval(() => {
      if (this.sec > 1) {
        this.sec--;
        this.sec = this.sec<10 ? '0'+this.sec : this.sec
        sessionStorage.setItem("fi_sec", this.sec);
      } else {
        this.sec = 60;
      }
    }, 1000);
  }

  countdown_min() {
    setInterval(() => {
      if (this.min >= 0) {
        this.min--;
        this.min = this.min<10 ? '0'+this.min : this.min;
        sessionStorage.setItem("fi_min", this.min);
        if(this.min == 0) {
            alert("You are Out from this Session...!!")
            this.logout();
        }
      }

      // else {
      //   this.min = 60;
      // }
    }, 60000);
  }

  countdown_hr() {
    setInterval(() => {
      if (this.hr >= 0) {
        this.hr--;
        this.hr = this.hr<10 ? '0'+this.hr : this.hr;
        sessionStorage.setItem("fi_hr", this.hr);
      }
      //  else {
      //   this.hr = 60;
      // }
    }, 3600000);
  }
//  ============================================================================================================

    refresh_page(): void {
      window.location.reload();
    }

//  ============================================================================================================
//  ============================================================================================================

}

 
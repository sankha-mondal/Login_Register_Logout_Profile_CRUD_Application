import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  storeMsg: string = ""
  uName: string = "";
  uEmail: string = "";
  uPhone: string = "";
  uPassword: string = "";
  new_password: string = "";
  confirm_password: string = "";
  uAddress: string = "";
  uRole: string = "";
  url: string = "";

  constructor(private ps: UserService,
              private router: Router,
              private titleService: Title) {
                this.titleService.setTitle("Register Page");
              }

  ngOnInit() {
  }

  // =====================================  : Registration of Users : =============================================

  store_User(userRef_store: NgForm): void {
    let new_user = userRef_store.value.new_password;
    console.log("New Password: " + new_user);
    let confirm_pass = userRef_store.value.confirm_password;
    console.log("Confirm Password: " + confirm_pass);
    console.log(userRef_store.value)

    if (new_user == confirm_pass) {
      let user = {
        uEmail: this.uEmail,
        uName: this.uName,
        uPhone: this.uPhone,
        uPassword: confirm_pass,
        uRole: this.uRole,
        uAddress: this.uAddress,
        url: this.url
      }

      this.ps.store_User(user).subscribe(result => {
        this.storeMsg = result;
        console.log(user);
        alert(this.storeMsg);
      }, error => console.log(error), () => {
        // this.router.navigate(["login"], {skipLocationChange:true});
      })
      userRef_store.reset();
    }
    else {
      alert("Your Password and Confirm Password must be same...")
    }
  }

}
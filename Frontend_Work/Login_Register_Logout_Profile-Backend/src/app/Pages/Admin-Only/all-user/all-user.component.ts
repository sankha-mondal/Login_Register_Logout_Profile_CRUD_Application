import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'src/app/Interfaces/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css']
})
export class AllUserComponent implements OnInit {

  user:Array<User>=[];   // user array memory created..

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

  searchText: string = "";

  constructor(private us: UserService,
              private router: Router,
              private titleService: Title) {
                this.titleService.setTitle("All Users");
        }

  ngOnInit(): void {
    this.get_All_User();
  }

//================================================ :Retrieve Operation: =======================================================

  get_All_User(): void {
      this.us.getAll_User().subscribe(result=> {
        this.user = result;
        console.log("All data comming for profile compo...")
        console.log(result);   // details for all users
      })    
  }

//================================================= :Delete Operation: ==========================================================

  delete_User(uEmail: string): void {

      if(confirm("Are you sure..!?")) {
      this.us.delete_User(uEmail).subscribe(result=> {
        this.deleteMsg=result;
        alert(this.deleteMsg);
      },error=>console.log(error),()=> {
        this.get_All_User();
      })
      }
  }

//=============================================== :Update Operation: ===============================================================

  get_record_for_update(user: User): void {

    this.uEmail = user.uEmail;
    this.uName = user.uName;
    this.uPhone = user.uPhone;
    this.uPassword = user.uPassword;
    this.uRole = user.uRole;
    this.uAddress = user.uAddress;
    this.url = user.url;
  }
  
  update_User() {

    let user = {
                uEmail : this.uEmail,
                uName : this.uName,
                uPhone : this.uPhone,
                uPassword : this.uPassword,
                uRole : this.uRole,
                uAddress : this.uAddress,
                url : this.url,
              }

    this.us.update_User(this.uEmail, user).subscribe(result=> {
      this.updateMsg=result;
      // alert(this.updateMsg);
      alert("Passenger Profile update Successfully...")
    },error=> console.log(error),()=> {
      this.get_All_User();
    })
  }

// ===========================================================================================================================

admin_home_page(): void {
  this.router.navigate(["admin/home"], {skipLocationChange:true});

}

//  ============================================================================================================

}


import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { EmailService } from 'src/app/Services/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  constructor(private es: EmailService,
              private route: Router,
              private titleService: Title) {
                  this.titleService.setTitle("Email Info");
  }

  ngOnInit(): void {
  }

  title = 'Email Template';
  recipient: string = "";
  subject: string = "";
  msgBody: string = "Hey,\n        This is your Booking Details:-\n        ----------*----------*----------*----------\n\n============================================================\n        Booking Id:\n        Email:\n        Passenger Name:\n        Phone No:\n        Address:\n        ================================\n        Journey Date:\n        Journey Time:\n        ================================\n        Source Point:\n        Destination Point:\n        Distance in KM:\n        ================================\n        Ship Name:\n        Ship Model:\n        ================================\n        HC Name:\n        HC Age:\n        HC Gender:\n        ================================\n        No of Head-Count:\n        Payment Amount:                  /-\n============================================================\n        \n\nHappy Journey.\n\nThanks & Regards,\nAdmin\nadmin@ad.com";
  attachment: string = "";

  file: any;

  sendMsg: string = "";
  styProperty1 = { 'display': 'none' };

// ============== ============== ============= ============= ============= ============= ============= =============  

  send_Email(emailRef_send: NgForm): void {
    let email = emailRef_send.value;
    console.log(email);
    this.styProperty1 = { 'display': '' };
    this.es.send_Email(email).subscribe(
      result => {
        this.styProperty1 = { 'display': 'none' };
        this.sendMsg = result;
        alert(this.sendMsg);
        emailRef_send.reset();
      }, error => {
        console.log(error);
        this.styProperty1 = { 'display': 'none' };
        alert("Email not Sent...!\nTurn on your Internet...")
      }
    )
  }

// ============== ============== ============= ============= ============= ============= ============= =============

  selectFile(event: any) {
    console.log("Choosed File: ")
    console.log(event);
    this.file = event.target.files[0];
    console.log(this.file);
  }

  send_Email_with_Attachment(emailRef_send: NgForm): void {
    let email = emailRef_send.value;
    console.log(email);
    this.styProperty1 = { 'display': '' };
    this.es.send_Email_with_Attachment(email).subscribe(
      result => {
        this.styProperty1 = { 'display': 'none' };
        this.sendMsg = result;
        alert(this.sendMsg);
        emailRef_send.reset();
      }, error => {
        console.log(error);
        this.styProperty1 = { 'display': 'none' };
        alert("Email not Sent...!!!\n")
      }
    )
  }

// ============== ============== ============= ============= ============= ============= ============= =============
// ============== ============== ============= ============= ============= ============= ============= =============  

}

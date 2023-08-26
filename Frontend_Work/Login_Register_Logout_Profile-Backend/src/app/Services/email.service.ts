import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Email } from '../Interfaces/email';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(public http: HttpClient) { }  // DI for HttpClient

  private apiUrles = "http://localhost:8585/users_credentials/email";

// ===========================================================================================================================

  send_Email(email: any) :Observable<string> {  // for Admin
      return this.http.post(this.apiUrles+"/sendMail",email,{responseType:'text'});
  }

  send_Email_with_Attachment(email: Email) :Observable<string> {  // for Admin
    return this.http.post("http://localhost:8585/email/sendMailWithAttachment",email,{responseType:'text'});
  }

  get_Email(email: any) :Observable<string> {   // for User
    return this.http.post(this.apiUrles+"/sendMail",email,{responseType:'text'});
  }


  get_Email_with_Attachment(email: any) :Observable<string> {  // for User
    return this.http.post(this.apiUrles+"/sendMailWithAttachment",email,{responseType:'text'});
  }

// ===========================================================================================================================
// ===========================================================================================================================

}


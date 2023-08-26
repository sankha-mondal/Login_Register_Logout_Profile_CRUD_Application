import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public http: HttpClient) { }  // DI for HttpClient

  private apiUrlps = "http://localhost:8585/users_credentials/user";

// ===============================================================================================================================

  //  http://localhost:8585/users_credentials/user/getAll
  getAll_User(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrlps + "/getAll");
  }

  //  http://localhost:8585/users_credentials/user/getPassByEmail/{uEmail}
  getOne_User(uEmail: string): Observable<User> {  // no neeed of Passenger[]
    return this.http.get<User>("http://localhost:8585/users_credentials/user/getUserByEmail/" + uEmail);
  }

  //  http://localhost:8585/users_credentials/user/store
  //  By default all HttpClient method return type is json then we have to write responseType as Text.

  store_User(user: any): Observable<string> {
    return this.http.post(this.apiUrlps + "/store", user, { responseType: 'text' });
  }

  //  http://localhost:8585/users_credentials/user/delete/{uEmail}
  delete_User(uEmail: string): Observable<string> {
    return this.http.delete(this.apiUrlps + "/delete/" + uEmail, { responseType: "text" });
  }

  //  http://localhost:8585/users_credentials/user/update/{uEmail}
  update_User(uEmail: any, user: any): Observable<string> {
    return this.http.put(this.apiUrlps + "/update/" + uEmail, user, { responseType: "text" })
  }

  //  http://localhost:8585/users_credentials/user/login
  login(user: User): Observable<string> {
    return this.http.post(this.apiUrlps + "/login", user, { responseType: 'text' });
  }

}
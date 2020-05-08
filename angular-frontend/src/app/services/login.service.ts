import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http'; // import HTTP symbols
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
/*********LoginService***********
 * Talks to backend specifically for logging in purposes
 * // TODO: add logging with some message component
 */
export class LoginService {

  private loginUrl = 'http://3.93.151.87:8088/ReflectQuiz/users/login';
  /* web API expects a special header in HTTP save requests */
  httpOptions = { headers: new HttpHeaders({'Content-Type' : 'application/json'}) }; 

  constructor(private http: HttpClient) { }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); 
      return of(result as T);
    };
  }

  public userCreds = {
          "id": "",
          "username": "",
          "userpassword": "",
          "userRole": ""
      };
  isLoggedIn:boolean;
  setLoggedIn(){
    console.log("loggedIn=true")
    this.isLoggedIn = true;
  }
  getLoggedIn():boolean{
    return this.isLoggedIn;
  }
  getLogin(username:string, password:string) : Observable<User> {
      this.userCreds.username = username;
      this.userCreds.userpassword = password;
      let currentUser:Observable<User> = this.http.post<User>(this.loginUrl, this.userCreds, this.httpOptions);
      return currentUser;
  }
}

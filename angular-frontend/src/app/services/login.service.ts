import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http'; // import HTTP symbols
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
/*********LoginService***********
 * Talks to backend specifically for logging in purposes
 * // TODO: add logging with some message component
 */
export class LoginService {

  private loginUrl = 'reflect-quiz/users/login';
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

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      //this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  public userCreds = {
          "username": "",
	  "password": ""
      };

  getLogin(username:string, password:string) : Observable<any> {
      this.userCreds.username = username;
      this.userCreds.password = password;
      return this.http.post<string>(this.loginUrl, this.userCreds, this.httpOptions) as Observable<any>;
  }

}

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

  /* Base login URL used to request backend services */
  private loginUrl = 'api/login'; //api can be changed
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
  /**
   * Handle Http operation for logging in.
   * // TODO: Add service specific to login, change Observable typing to login model (probably just a boolean with username or with type)
   * @param username - username input
   * @return - returns an Observable for the login
   */
  /*getLogin(username: string): Observable<any> {
    //return this.http.get('http://localhost:8088/Servlets/whatsup') as Observable<any>; //Christina's http get version
    return this.http.get<any>(this.loginUrl).pipe(
      catchError(this.handleError<any>(`Login to ...`)))
    ); // tour of heroes get version, pipe is used to pipe an object from the observable
    //return of(HEROES.find(hero=>hero.id === id));  // returns mock hero as an Observable using RxJS of() function (asynchronous)}}
  }  */

}

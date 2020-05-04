import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from '../models/user';

@Injectable({  providedIn: 'root' })
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  private userUrl = 'api/users';

  private handleError<T>(operator = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  getUser(id: number): Observable<User>{
    const url = '${this.userUrl}/${id}';
    return this.http.get<User>(url).pipe(tap(_ => {/*log stuff?*/}),
    catchError(this.handleError<User>('getUser id=${id}'))
    ); 
  }

/* GET heroes whose name contains search term */
searchUser(term: string): Observable<User[]> {
  if (!term.trim()) {
    // if not search term, return empty hero array.
    return of([]);
  }
  return this.http.get<User[]>(`${this.userUrl}/?name=${term}`).pipe(
    tap(x => {},
    catchError(this.handleError<User[]>('searchHeroes', []))
  ));
}

//////// Save methods //////////

/** POST: add a new hero to the server */
addUser(user: User): Observable<User> {
  return this.http.post<User>(this.userUrl, user, this.httpOptions).pipe(
    tap((newHero: User) => {}),
    catchError(this.handleError<User>('addUser'))
  );
}

/** DELETE: delete the hero from the server */
deleteUser(user: User | number): Observable<User> {
  const id = typeof user === 'number' ? user : user.getId();
  const url = `${this.userUrl}/${id}`;

  return this.http.delete<User>(url, this.httpOptions).pipe(
    tap(_ => {}),
    catchError(this.handleError<User>('deleteHero'))
  );
}

/** PUT: update the hero on the server */
updateUser(user: User): Observable<any> {
  return this.http.put(this.userUrl, user, this.httpOptions).pipe(
    tap(_ => {}),
    catchError(this.handleError<any>('updateUser'))
  );
}
}

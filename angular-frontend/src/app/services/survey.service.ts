import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

import { Survey } from '../models/survey';

@Injectable({  providedIn: 'root' })
export class SurveyService {

  constructor(
    private http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  private surveyUrl = 'http://3.93.151.87:8088/ReflectQuiz/Survey';

  private handleError<T>(operator = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  getSurvey(id: number): Observable<Survey>{
    const url = '${this.surveyUrl}/id/${id}';
    return this.http.get<Survey>(url).pipe(tap(_ => {/*log stuff?*/}),
    catchError(this.handleError<Survey>('get survey id=${id}'))
    ); 
  }

  /* GET all surveys */
  getAllSurvey(): Observable<any> {
    const url = this.surveyUrl.concat('/alls');
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Survey>('get all surveys')));
  }

  //////// Save methods //////////

  /** POST: add a new User to the server */
  addSurvey(survey: Survey): Observable<Survey> {
    return this.http.post<Survey>(this.surveyUrl.concat('/new'), survey, this.httpOptions).pipe(
      tap((newSurvey: Survey) => {}),
      catchError(this.handleError<Survey>('addSurvey'))
    );
  }

}

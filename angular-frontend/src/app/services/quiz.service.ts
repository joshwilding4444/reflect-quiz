import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

import { Quiz } from '../models/quiz'

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  private quizUrl = 'http://3.93.151.87:8088/ReflectQuiz/quiz';

  private handleError<T>(operator = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  getQuiz(id: number): Observable<any>{
    const url = this.quizUrl.concat('/id/'.concat(`${id}`));
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Quiz>('get Quiz id=${id}'))
    ); 
  }

  /* GET all Quiz */
  getAllQuiz(): Observable<any> {
    const url = this.quizUrl.concat('/allq');
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Quiz>('get all Quiz')));
  }

  //////// Save methods //////////

  /** POST: add a new Quiz to the server */
  addQuiz(quiz: Quiz): Observable<Quiz> {
    return this.http.post<Quiz>(this.quizUrl.concat('/new'), quiz, this.httpOptions).pipe(
      tap((newQuiz: Quiz) => {}),
      catchError(this.handleError<Quiz>('Quiz'))
    );
  }

   /** POST: add a new Quiz to the server */
   updateQuiz(quiz: Quiz): Observable<Quiz> {
    return this.http.post<Quiz>(this.quizUrl.concat('/update'), quiz, this.httpOptions).pipe(
      tap((newQuiz: Quiz) => {}),
      catchError(this.handleError<Quiz>('update Quiz'))
    );
  }

  updateQuizQuestions(quiz: Quiz): Observable<Quiz> {
    return this.http.post<Quiz>(this.quizUrl.concat('/update/questions'), quiz, this.httpOptions).pipe(
      tap((newQuiz: Quiz) => {}),
      catchError(this.handleError<Quiz>('update Quiz questions'))
    );
  }
}

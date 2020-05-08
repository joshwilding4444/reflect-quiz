import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

import { Question } from '../models/question'

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  private questionUrl = 'http://3.93.151.87:8088/ReflectQuiz/question';

  private handleError<T>(operator = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  getQuestion(id: number): Observable<any>{
    const url = this.questionUrl.concat('/id/'.concat(`${id}`));
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Question>('get Question id=${id}'))
    ); 
  }

  getQuestionByTopic(topic: string): Observable<any>{
    const url = this.questionUrl.concat('/topic/'.concat(topic));
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Question>('get Question topic=${topic}'))
    ); 
  }

  /* GET all Questions */
  getAllQuestion(): Observable<any> {
    const url = this.questionUrl.concat('/allq');
    return this.http.get(url, this.httpOptions).pipe(map(res => JSON.stringify(res)),
    catchError(this.handleError<Question>('get all Question')));
  }

  //////// Save methods //////////

  /** POST: add a new Question to the server */
  addQuestion(question: Question): Observable<Question> {
    return this.http.post<Question>(this.questionUrl.concat('/new'), question, this.httpOptions).pipe(
      tap((newQuestion: Question) => {}),
      catchError(this.handleError<Question>('addQuestion'))
    );
  }

   /** POST: add a new Question to the server */
   updateQuestion(question: Question): Observable<Question> {
    return this.http.post<Question>(this.questionUrl.concat('/update'), question, this.httpOptions).pipe(
      tap((newQuestion: Question) => {}),
      catchError(this.handleError<Question>('update Question'))
    );
  }
}

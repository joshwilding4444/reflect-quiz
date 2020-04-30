import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  currentUser = {
  	      	"username": "",
		"password": ""
  	      };
  submitted = false;

  onSubmit() {
      this.submitted = true;
      this.loginRequest = JSON.stringify(this.currentUser);
      this.submitLoginCreds(this.loginRequest);
  }
  //this method is only for verifying that we create
  //proper JSON
  get diagnostic() {
      return JSON.stringify(this.currentUser);
  }
  loginRequest:string = "";
  //targetURL = 'https://postman-echo.com/get?test=123';
  targetURL = 'https://c5486636-34c1-4b70-9f37-8b522190b18f.mock.pstmn.io/testlogin';

  httpOptions = {
     headers : new HttpHeaders({
        'Content-Type': 'application/json'
     })
  };

  submitLoginCreds(inputCreds:string) : Observable<string> {
      return this.http.post<string>(this.targetURL, inputCreds, this.httpOptions);
  }

}



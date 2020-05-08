import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router'
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
//import { InMemoryDbService } from 'angular-in-memory-web-api';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

/*********Login********
 * Used to login to quiz system.  
 * //TODO: add login service implementations
 */
export class LoginComponent implements OnInit {
  /*Fields defined for login*/
  @ViewChild('loginForm') formValues;
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  public userCreds  = {
  	      	"username": "",
		        "password": ""
  	      };

  onSubmit():void {
    this.getLogin(this.userCreds.username, this.userCreds.password);
  }

  user:User;
  
  /**
   * Gets the login status with resulting login value
   * @param username: login username
   * @param password: login password
   * @return: returns nothing atm
   */
public isLoggedIn:boolean;

  getLogin(username:string, password:string): void{
    this.loginService.getLogin(username, password).subscribe(
      (data) =>{ 
            this.user = JSON.parse(JSON.stringify(data));
            console.log(this.user);
            sessionStorage.setItem('currentUser', JSON.stringify(this.user));
            sessionStorage.setItem('role', this.user.userRole);
            this.router.navigate(['/quiz/view']);
      },
      () => { 
        this.formValues.resetForm();
        console.log("Error in retrieving login info!");
      }
    )
  }
}
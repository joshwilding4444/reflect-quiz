import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user' 

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  //id: number;
  username: string;
  userRole: string;

  //this should be called everytime the user logs in or out.
  userChanged(userLoggedIn: User): void {
    //this.id = userLoggedIn.getId();
    this.username = userLoggedIn.getUsername();
    this.userRole = userLoggedIn.getUserRole();
  }
}

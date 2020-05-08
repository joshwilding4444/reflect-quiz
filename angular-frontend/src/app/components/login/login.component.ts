import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

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

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  /**
   * Gets the login status with resulting login value
   * @param username: login username
   * @param password: login password
   * @return: returns nothing atm
   */
  getLogin(): void{
    /*this.loginService.getLogin().subscribe(
      (data) =>{ //what happens when data is recieved from request
        console.log(data);
        console.log(data[0]);
        this.jokes = data; //initialize your array of jokes to whatever was returned from the server
      },
      () => { // what happens when nothing returned during subscribe
        console.log("There was an error grabbing your jokes!");
      }
    )*/
  }
  // method to call heroService and add a hero to the server
  /*add(name: string):void { // this is the way tour of heroes pushes data
    name = name.trim();
    if(!name) return;
    this.heroService.addHero({name} as Hero)
      .subscribe(hero=>{this.heroes.push(hero)}); // when addHero() saves successfully, subscribe() callback revieves new hero and pushes into this.heroes for display
  }*/
  
  /*submitJoke(){ //this is Christinas way of pushing info
    this.jokes.push(
      new Joke(this.joke.getId(), 
               this.joke.getContent()
               )
    )

    this.jokeService.sendJoke(this.joke);

    this.joke.setId(0);
    this.joke.setContent('NA');
  }*/


}

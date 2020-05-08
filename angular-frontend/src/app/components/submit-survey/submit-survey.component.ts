import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Survey } from 'src/app/models/survey';
import { SurveyService } from 'src/app/services/survey.service'

@Component({
  selector: 'app-submit-survey',
  templateUrl: './submit-survey.component.html',
  styleUrls: ['./submit-survey.component.css']
})
export class SubmitSurveyComponent implements OnInit {

  
  theSurvey: Survey;
  theSurveyPostSend: Survey;
  studentID: number;
  quizID: number;

  constructor(private surveyService: SurveyService) { }

  ngOnInit(): void {
    //TODO: change the following calls to the current 
    this.quizID = 999; //Change to getting the current quiz!
    this.studentID = 999; //Change to getting the currently logged in user!
    this.theSurvey = new Survey(this.quizID, this.studentID, "nothing was entered")
  }

  formFG = new FormGroup({
    survey: new FormControl('', Validators.required)
  });
  // used to pull up question if it was selected
  isfinshed: boolean;

  onSubmit(){
    this.theSurvey.setSurveyInputField(this.formFG.get('survey').value);
    console.log(JSON.stringify(this.theSurvey));
    
    this.add(this.theSurvey);
    console.log(JSON.stringify(this.theSurveyPostSend));
  }

  add(surveyToAdd: Survey): void {
    if (!surveyToAdd) { return; }
    this.surveyService.addSurvey(surveyToAdd as Survey)
      .subscribe(surveyToAdd => {
        this.theSurveyPostSend = surveyToAdd;
      });
  }
}

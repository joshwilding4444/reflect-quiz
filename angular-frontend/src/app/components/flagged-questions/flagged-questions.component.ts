import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { of } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { Question } from 'src/app/models/question';
import { Options } from 'src/app/models/options'

@Component({
  selector: 'app-flagged-questions',
  templateUrl: './flagged-questions.component.html',
  styleUrls: ['./flagged-questions.component.css']
})
export class FlaggedQuestionsComponent implements OnInit {

  // List of Flagged Questions
  flaggedQuestionsArray: Question[];
  // Helper class with Dropdown choices
  options: Options;
  // Chosen Question Form List
  selectedQuestion: Question;
  formFG = new FormGroup({
    topic: new FormControl('', Validators.required),
    question: new FormControl('', Validators.required),
    answerListA: new FormControl('', Validators.required),
    answerListB: new FormControl('', Validators.required),
    answerListC: new FormControl('', Validators.required),
    answerListD: new FormControl('', Validators.required),
    correctAnswer: new FormControl('', Validators.required),
    difficulty: new FormControl('', Validators.required)
  });
  // used to pull up question if it was selected
  isInitialized: boolean;
  // correct answer
  orders: {};
  // topics
  orders2: {};
  // difficulty
  orders3: {};

  answerListCombined: string;

  // Testing
  getMockedFlaggedQuestions(): Question[]{ //needs to be updated with grabbing questions form the database
    return [new Question(999, 'questionA', 'a,b,c,d', 'a', 5, 'Art'), new Question(1000, 'questionB', 'a,b,c,d', 'a', 5, 'Art')];
  }

  constructor() { 
    this.options = new Options();
    this.answerListCombined = "";
  }

  onSubmit(){

    this.combineAnswerList();
    this.updateQuestion(); //updates the angular model with the input fields
    //update the question in the database
    this.isInitialized = false;
  }

  /**Updates Question that is currently selected */
  updateQuestion(){
    console.log("Updating" + this.formFG.get('question').value)

    this.selectedQuestion.setQuestion(this.formFG.get('question').value);
    this.selectedQuestion.setAnswerList(this.answerListCombined);
    this.selectedQuestion.setCorrectAnswer(this.formFG.get('correctAnswer').value);
    this.selectedQuestion.setDifficulty(this.formFG.get('difficulty').value);
    this.selectedQuestion.setTopic(this.formFG.get('topic').value);
    console.log(JSON.stringify(this.selectedQuestion));
  }

  onSelect(question: Question): void{
    this.selectedQuestion = question;
    this.isInitialized = true;

  }
  markerSymbol: string = " @:";
  combineAnswerList() {
    console.log("answerA "+this.formFG.get('answerListA').value);
    this.answerListCombined ="" + this.markerSymbol
                                + this.formFG.get('answerListA').value
                                + this.markerSymbol
                                + this.formFG.get('answerListB').value
                                + this.markerSymbol
                                + this.formFG.get('answerListC').value
                                + this.markerSymbol
                                + this.formFG.get('answerListD').value;

    console.log(this.answerListCombined);
  }

  ngOnInit(): void {
    this.flaggedQuestionsArray = this.getMockedFlaggedQuestions();
    this.orders = this.options.getAnswers();
    this.orders2 = this.options.getTopic();
    this.orders3 = this.options.getDifficulty();
    console.log(JSON.stringify(this.flaggedQuestionsArray));

    //this.isInitialized = true;

  }

}

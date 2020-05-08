import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormBuilder } from '@angular/forms';
import { of } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { Question } from 'src/app/models/question';
import { QuestionService } from 'src/app/services/question.service';

@Component({
  selector: 'app-flagged-questions',
  templateUrl: './flagged-questions.component.html',
  styleUrls: ['./flagged-questions.component.css']
})
export class FlaggedQuestionsComponent implements OnInit {

  flaggedQuestionsArray: Question[];
  selectedQuestion: Question;

  FlaggedQuestions: Question[];

  getFlaggedQuestions(): Question[]{ 
    return this.FlaggedQuestions;
  }

  getQuestions(): void {
    this.questionService.getAllQuestion()
    .subscribe((data) => {
      console.log(data);
      console.log(JSON.parse((data)));
      this.flaggedQuestionsArray = <Question[]>JSON.parse((data))
    });
  }

  questionToUpdate: Question;

  form: FormGroup;
  orders = [];

  form2: FormGroup;
  orders2 = [];

  form3: FormGroup;
  orders3 = [];

  @Input() questionInput: string; 
  @Input() answerListA: string; 
  @Input() answerListB: string; 
  @Input() answerListC: string; 
  @Input() answerListD: string;
  answerListCombined: string; 

  constructor(private formBuilder: FormBuilder, private formBuilder2: FormBuilder,
    private formBuilder3: FormBuilder, private formBuilder4: FormBuilder, private questionService: QuestionService) { 

    this.getQuestions();
    
    this.flaggedQuestionsArray =  this.getFlaggedQuestions();
    this.selectedQuestion = new Question(99999, "Select A Question to edit it", "nothing here", "C",
    3, "MATH", 0)
    
    this.form = this.formBuilder.group({
      orders: ['']
    });

    this.form2 = this.formBuilder2.group({
      orders2: ['']
    });

    this.form3 = this.formBuilder3.group({
      orders3: ['']
    });

    //async orders
    of(this.getOrders()).subscribe(orders => {
      this.orders = orders;
      this.form.controls.orders.patchValue(this.orders[0].id);
    });

    of(this.getOrders2()).subscribe(orders2 => {
      this.orders2 = orders2;
      this.form2.controls.orders2.patchValue(this.orders2[0].id);
    });

    of(this.getOrders3()).subscribe(orders3 => {
      this.orders3 = orders3;
      this.form3.controls.orders3.patchValue(this.orders3[0].id);
    });
  }

  getOrders() {
    return [
      { id: 1, name: 'A'},
      { id: 2, name: 'B'},
      { id: 3, name: 'C'},
      { id: 4, name: 'D'}
    ];
  }

  getOrders2() {
    return [
      { id: 1, name: 'Math'},
      { id: 2, name: 'Science'},
      { id: 3, name: 'History'},
      { id: 4, name: 'Grammer'}
    ];
  }

  getOrders3() {
    return [
      { id: 1, name: '1'},
      { id: 2, name: '2'},
      { id: 3, name: '3'},
      { id: 4, name: '4'},
      { id: 5, name: '5'}
    ];
  }

  submit(){
    this.combineAnswerList();
    //this.questionToUpdate.setID(note:----get the question to update it, we need it's ID----)
    this.updateQuestion(); //updates the angular model with the input fields
    //update the question in the database
  }

  updateQuestion(){
    this.questionToUpdate.setQuestion(this.questionInput)
    this.questionToUpdate.setAnswerList(this.answerListCombined)
    this.questionToUpdate.setCorrectAnswer(this.form2.value)
    this.questionToUpdate.setDifficulty(this.form3.value)
    this.questionToUpdate.setTopic(this.form2.value)
  }

  markerSymbol: string = "@";
  combineAnswerList(){
    this.answerListCombined.concat(this.answerListA);
    this.answerListCombined.concat(this.markerSymbol);
    this.answerListCombined.concat(this.answerListB);
    this.answerListCombined.concat(this.markerSymbol);
    this.answerListCombined.concat(this.answerListC);
    this.answerListCombined.concat(this.markerSymbol);
    this.answerListCombined.concat(this.answerListD);
  }

  onSelect(question: Question): void{
    this.selectedQuestion = question;
  }
  
  ngOnInit(): void {
  }
}

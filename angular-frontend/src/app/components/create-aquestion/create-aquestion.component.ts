import { Component, OnInit, Input } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormBuilder } from '@angular/forms';
import { of } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { Question } from '../../models/question';

@Component({
  selector: 'app-create-aquestion',
  templateUrl: './create-aquestion.component.html',
  styleUrls: ['./create-aquestion.component.css']
})
export class CreateAQuestionComponent implements OnInit {
  
  newQuestion: Question;
  form: FormGroup;
  orders = {};

  form2: FormGroup;
  orders2 = {};

  form3: FormGroup;
  orders3 = {};

  @Input() questionInput: string; 
  @Input() answerList: string; 

  constructor(private formBuilder: FormBuilder, private formBuilder2: FormBuilder, private formBuilder3: FormBuilder) { 
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
      { id: 5, name: '5'},
      { id: 6, name: '6'},
      { id: 7, name: '7'},
      { id: 8, name: '8'},
      { id: 9, name: '9'},
      { id: 10, name: '10'}
    ];
  }

  onSubmit(){
    this.createQuestion();
    // persist question to DB
    //add the question to the database
  }

  createQuestion(){
    this.newQuestion.setQuestion(this.questionInput)
    this.newQuestion.setAnswerList(this.answerList)
    this.newQuestion.setCorrectAnswer(this.form2.value)
    this.newQuestion.setDifficulty(this.form3.value)
    this.newQuestion.setTopic(this.form2.value)
  }


  ngOnInit(): void {
  }

}

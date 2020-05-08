import { Component, OnInit, ViewChild } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { Quiz } from 'src/app/models/quiz';
import { Options } from 'src/app/models/options';
import { Question } from 'src/app/models/question';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-quiz-take',
  templateUrl: './quiz-take.component.html',
  styleUrls: ['./quiz-take.component.css']
})
export class QuizTakeComponent implements OnInit {
  // running total for each question in this quiz (is size of question pool)
  questionsAnswers:number[];
  questionsList:Question[];
  questionsByDifficulty = [];
  quizToTake: Quiz;
  possibleAnswers: {};
  options = new Options;
  currentScore: number;
  currentLevel: number;
  currentDifficultyList: Question[];
  answerInput = new FormGroup({
    answer: new FormControl('', Validators.required)
  });
  startingLength: number;
  isSubmitted: boolean;

  // current question being asked and responded to
  currentQuestion: Question[];
  answerListParsed: string[];
  constructor(private activatedRoute:ActivatedRoute) { }

  // on initialization, gets quiz from backend and populates local quiz variables
  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    console.log(id);
    // get quiz from DB with provided ID
    // po answers to a question
    this.possibleAnswers = this.options.getAnswers();
    //testing
    //this.getMockedQuestions();
    this.quizToTake = JSON.parse(sessionStorage.getItem('quizTake'));
    console.log(this.quizToTake);
    this.currentLevel = this.quizToTake.startingdifficulty;
    this.questionsList = this.quizToTake.questions;
    this.questionsByDifficulty.push(this.getQuestionByLevel(1));
    this.questionsByDifficulty.push(this.getQuestionByLevel(2));
    this.questionsByDifficulty.push(this.getQuestionByLevel(3));
    this.questionsByDifficulty.push(this.getQuestionByLevel(4));
    this.questionsByDifficulty.push(this.getQuestionByLevel(5));
    this.isSubmitted=false;
    this.startingLength=this.quizToTake.quizlength;
    this.currentDifficultyList = this.questionsByDifficulty[this.currentLevel-1];
    this.currentQuestion = [this.currentDifficultyList[this.getRandomInt(this.currentDifficultyList.length)]];
  }

  // When User Checks an Answer
  checkAnswer(){
    if(this.currentQuestion[0].correctanswer===this.answerInput.get('answer').value){
      console.log(this.currentQuestion[0].correctanswer===this.answerInput.get('answer').value)
      this.correctAnswer();
    }
    else{
      this.incorrectAnswer();
    }
  }

  correctAnswer(){
    if(this.currentLevel < 5){
      this.currentLevel++;
    }
    this.currentDifficultyList = this.questionsByDifficulty[this.currentLevel-1];
    this.currentQuestion[0] = this.currentDifficultyList[this.getRandomInt(this.currentDifficultyList.length)];
    this.removeDocument(this.currentQuestion[0]);
    this.startingLength--;
    if(this.startingLength == 0)
      console.log("You had A Score of " + this.currentLevel)
  }

  removeDocument(doc:Question){
    this.currentDifficultyList.forEach( (item, index) => {
      if(item === doc) this.currentDifficultyList.splice(index,1);
    });
 }

  incorrectAnswer(){
    if(this.currentLevel > 1){
      this.currentLevel--;
    }
    this.currentDifficultyList = this.questionsByDifficulty[this.currentLevel-1];
    this.currentQuestion[0] = this.currentDifficultyList[this.getRandomInt(this.currentDifficultyList.length)];
    this.removeDocument(this.currentQuestion[0]);
    this.startingLength--;
    if(this.startingLength == 0)
      console.log("You had A Score of " + this.currentLevel)
  }

  getQuestionByLevel(level:number):Question[]{
    return this.questionsList.filter(q => q.difficulty === level);
  }

  populateRunningTotal(){
    for (let i in this.quizToTake.getQuestions){
      this.questionsAnswers[i] = 0; //
    }
  }

   //Parse answerList String to display with question details.
   parseQuestionAnswerList(answerList: string):string[]{
    return this.answerListParsed = answerList.split(' @:');
  }

  concateParsedAnswerList(parsedAnswerList:string[]):string{
return "A: " + parsedAnswerList[0] + " B: " + parsedAnswerList[1] + " C: " + parsedAnswerList[2] + " D: " +parsedAnswerList[3] 
  }

  getRandomInt(max:number):number {
    return Math.floor(Math.random() * Math.floor(max));
  }

}

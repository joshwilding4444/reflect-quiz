import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { Quiz } from 'src/app/models/quiz';
import { Options } from 'src/app/models/options';
import { Question } from 'src/app/models/question';


@Component({
  selector: 'app-quiz-take',
  templateUrl: './quiz-take.component.html',
  styleUrls: ['./quiz-take.component.css']
})
export class QuizTakeComponent implements OnInit {
  // running total for each question in this quiz (is size of question pool)
  questionsAnswers:number[];
  questionsList:Question[];
  questionsByDifficulty:[any];
  quizToTake: Quiz;
  possibleAnswers: {};
  options: Options;
  currentScore: number;
  currentLevel: number;
  constructor(private activatedRoute:ActivatedRoute) { }

  mockedQuestions: Question[];
  getMockedQuestions(){ //needs to be updated with grabbing questions form the database
    this.mockedQuestions = [new Question(999, 'questionA', 'a,b,c,d', 'a', 5, 'Art'), new Question(1000, 'questionB', 'a,b,c,d', 'a', 5, 'Art')];
  }

  getMockedQuiz(): Quiz{
    return new Quiz(1, 5, 2, 'Art', this.mockedQuestions);
  }
  // on initialization, gets quiz from backend and populates local quiz variables
  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    console.log(id);
    // get quiz from DB with provided ID
    // populate possible answers to a question
    this.possibleAnswers = this.options.getAnswers();
    //testing
    this.getMockedQuestions();
    this.quizToTake = this.getMockedQuiz();
    this.currentLevel = this.quizToTake.getQuizLength();
    this.questionsList = this.quizToTake.getQuestions();
    this.questionsByDifficulty.push(this.getQuestionByLevel(1));
    this.questionsByDifficulty.push(this.getQuestionByLevel(2));
    this.questionsByDifficulty.push(this.getQuestionByLevel(3));
    this.questionsByDifficulty.push(this.getQuestionByLevel(4));
    this.questionsByDifficulty.push(this.getQuestionByLevel(5));
    
  }

  checkAnswer(){

  }

  correctAnswer(){
    
  }

  incorrectAnswer(){

  }

  getQuestionByLevel(level:number):Question[]{
    return this.questionsList.filter(q => q.getDifficulty() === level);
  }
  populateRunningTotal(){
    for (let i in this.quizToTake.getQuestions){
      this.questionsAnswers[i] = 0; //
    }
  }

}

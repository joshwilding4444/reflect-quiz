import { Component, OnInit } from '@angular/core';
import { Quiz } from 'src/app/models/quiz';
import { Question } from 'src/app/models/question';
import { Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  selectedQuiz: Quiz;
  quizzes: Quiz[];
  currentQuiz: Quiz;
  isChoosen: boolean;
  mockedQuestions: Question[];

  constructor(private router: Router) { }

  getMockedQuestions(){ //needs to be updated with grabbing questions form the database
    this.mockedQuestions = [new Question(999, 'questionA', 'a,b,c,d', 'a', 5, 'Art'), new Question(1000, 'questionB', 'a,b,c,d', 'a', 5, 'Art')];
  }

  getMockedQuiz(): Quiz[]{
    return [new Quiz(1, 5, 2, 'Art', this.mockedQuestions), new Quiz(2, 4, 1, 'Art', this.mockedQuestions)];
  }

  // chooses a quiz and lets you take if student, or edit if teacher
  selectQuiz(quiz:Quiz){
    this.selectedQuiz=quiz;
    this.isChoosen = true;
  }

  getQuizzesByTopic(){
    
  }

  editQuiz(quiz:Quiz){

  }

  takeQuiz(quiz:Quiz){
    this.router.navigate(['/quiz/take', quiz.getId()]);
  }
  backQuiz(){
    this.isChoosen = false;
  }

  ngOnInit(): void {
    this.getMockedQuestions();
    this.quizzes = this.getMockedQuiz();
  }

}

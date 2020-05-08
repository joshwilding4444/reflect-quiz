import { Component, OnInit, Input } from '@angular/core';
import { Question } from 'src/app/models/question';
import { QuestionService } from 'src/app/services/question.service';

@Component({
  selector: 'app-question-detail',
  templateUrl: './question-detail.component.html',
  styleUrls: ['./question-detail.component.css']
})
export class QuestionDetailComponent implements OnInit {
  @Input() question: Question;
  answerListParsed:string[];
  questions: Question[]
  //selectedQuestion: Question;
  constructor(private questionService: QuestionService) { }

  ngOnInit(): void {
    this.getAllQuestions();
  }

  getAllQuestions(){
    this.questionService.getAllQuestion()
    .subscribe((data) => {
      console.log(data);
      this.questions = JSON.parse((data))
    });
  }

  //Parse answerList String to display with question details.
  parseQuestionAnswerList(answerList: string):string[]{
    return this.answerListParsed = answerList.split(' @:');
  }

  concateParsedAnswerList(parsedAnswerList:string[]):string{
return "A: " + parsedAnswerList[0] + " B: " + parsedAnswerList[1] + " C: " + parsedAnswerList[2] + " D: " +parsedAnswerList[3] 
  }

  //addQuestionToQuiz(){
  //  this.selectedQuestion;
 // }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'; // makes HttpClientModule available everywhere in the app


/*****Place Component imports here *******/
import { LoginComponent } from './components/login/login.component';
import { UserComponent } from './components/user/user.component';
import { CreateAQuestionComponent } from './components/create-aquestion/create-aquestion.component';
import { FlaggedQuestionsComponent } from './components/flagged-questions/flagged-questions.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizDetailComponent } from './components/quiz-detail/quiz-detail.component';
import { QuizTakeComponent } from './components/quiz-take/quiz-take.component';
import { QuestionDetailComponent } from './components/question-detail/question-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    CreateAQuestionComponent,
    FlaggedQuestionsComponent,
    QuizComponent,
    QuizDetailComponent,
    QuizTakeComponent,
    QuestionDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

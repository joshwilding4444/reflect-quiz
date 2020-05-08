import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'; // imports routing capabilities
import { LoginComponent } from './components/login/login.component'; // gives router somewhere to go
import { CreateAQuestionComponent } from './components/create-aquestion/create-aquestion.component';
import { FlaggedQuestionsComponent } from './components/flagged-questions/flagged-questions.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizTakeComponent } from './components/quiz-take/quiz-take.component';
import { SubmitSurveyComponent } from './components/submit-survey/submit-survey.component';
import { VeiwCompletedSurveysComponent } from './components/veiw-completed-surveys/veiw-completed-surveys.component';
import { QuestionDetailComponent } from './components/question-detail/question-detail.component';

/********AppRoutingModule*******
 * In Angular, best practice is to load and configure router in a serparate top-level module imported by root AppModule.
 * 
 * Routes: Tells router which view to display when user clicks link or pasts URL into browser address bar
 *       - path: string that matches URL in browser address bar
 *       - component: component the router creates when navigating to this route
 * 
 * Specific Routes: 
 *  login - base login page
 *  question/create - make a new question
 *  question/update - update an existing question
 *  question/view - see all questions available for a teacher to update/ assign to a quiz
 *  survey/create - make a new survey
 *  survey/review - teacher sees what was written in review/ students can see review
 *  quiz/create - teacher can create new empty quiz
 *  quiz/update - teacher can add functionality to quiz/ update questions
 *  quiz/view - teacher sees all quizzes available to them as a list
 *  quiz/take - student sees questions dynamically changed based on previous answer
 */
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // when URL fully matches path (empty string), will redirect to /dashboard, default route          
  { path: 'login', component: LoginComponent}, 
  { path: 'question/create', component: CreateAQuestionComponent},
  { path: 'question/flagged', component: FlaggedQuestionsComponent},
  { path: 'question/view', component: QuestionDetailComponent},
  { path: 'survey/view/all', component: VeiwCompletedSurveysComponent},
  { path: 'survey/create', component: SubmitSurveyComponent},
  { path: 'quiz/take/:id', component: QuizTakeComponent},
  { path: 'quiz/view', component: QuizComponent}
];

/*******AppRoutingModule Internals*********
 * @NgModule: 
 *          - imports: adds RouterModule using forRoot method which configures router at app's root level, 
 *                                             supplies service providers and directives needed for routing, performs initial navigation
 *          - exports: makes RouterModule available throughout app
 */
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

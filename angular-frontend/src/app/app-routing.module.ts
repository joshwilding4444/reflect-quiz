import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'; // imports routing capabilities
import { LoginComponent } from './components/login/login.component'; // gives router somewhere to go
import { CreateAQuestionComponent } from './components/create-aquestion/create-aquestion.component';
import { FlaggedQuestionsComponent } from './components/flagged-questions/flagged-questions.component';

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
 *  quiz/take - student sees questions dynamically changed based on previous answer
 */
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // when URL fully matches path (empty string), will redirect to /dashboard, default route          
  { path: 'login', component: LoginComponent}, 
  { path: 'question/create', component: CreateAQuestionComponent},
  { path: 'question/flagged', component: FlaggedQuestionsComponent}
  /*{ path: 'question/update'},
  { path: 'question/view' },
  { path: 'survey/create'},
  { path: 'survey/review' },
  { path: 'quiz/create' },
  { path: 'quiz/update'},
  { path: 'quiz/take'}*/
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

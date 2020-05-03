import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'; // imports routing capabilities
import { LoginComponent } from './components/login/login.component'; // gives router somewhere to go

/********AppRoutingModule*******
 * In Angular, best practice is to load and configure router in a serparate top-level module imported by root AppModule.
 * 
 * Routes: Tells router which view to display when user clicks link or pasts URL into browser address bar
 *       - path: string that matches URL in browser address bar
 *       - component: component the router creates when navigating to this route
 * 
 */
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // when URL fully matches path (empty string), will redirect to /dashboard, default route          
  { path: 'login', component: LoginComponent} // displays login when localhost:8088/login is URL
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

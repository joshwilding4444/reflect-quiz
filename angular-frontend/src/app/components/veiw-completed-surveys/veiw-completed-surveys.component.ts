import { Component, OnInit } from '@angular/core';
import { Survey } from 'src/app/models/survey';
import { SurveyService } from 'src/app/services/survey.service'

@Component({
  selector: 'app-veiw-completed-surveys',
  templateUrl: './veiw-completed-surveys.component.html',
  styleUrls: ['./veiw-completed-surveys.component.css']
})
export class VeiwCompletedSurveysComponent implements OnInit {

  allSurveys: Survey[];

  constructor(private surveyService: SurveyService) { }

  ngOnInit(): void {
    this.getSurveys();
  }

  getSurveys(): void {
    this.surveyService.getAllSurvey()
    .subscribe(allSurveys => this.allSurveys = allSurveys);
  }
}

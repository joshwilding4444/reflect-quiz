import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitSurveyComponent } from './submit-survey.component';

describe('SubmitSurveyComponent', () => {
  let component: SubmitSurveyComponent;
  let fixture: ComponentFixture<SubmitSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

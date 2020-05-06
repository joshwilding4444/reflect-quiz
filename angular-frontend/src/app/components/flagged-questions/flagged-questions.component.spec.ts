import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlaggedQuestionsComponent } from './flagged-questions.component';

describe('FlaggedQuestionsComponent', () => {
  let component: FlaggedQuestionsComponent;
  let fixture: ComponentFixture<FlaggedQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlaggedQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlaggedQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

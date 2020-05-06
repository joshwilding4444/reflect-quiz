import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAQuestionComponent } from './create-aquestion.component';

describe('CreateAQuestionComponent', () => {
  let component: CreateAQuestionComponent;
  let fixture: ComponentFixture<CreateAQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

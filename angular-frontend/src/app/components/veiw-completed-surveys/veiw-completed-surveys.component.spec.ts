import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwCompletedSurveysComponent } from './veiw-completed-surveys.component';

describe('VeiwCompletedSurveysComponent', () => {
  let component: VeiwCompletedSurveysComponent;
  let fixture: ComponentFixture<VeiwCompletedSurveysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeiwCompletedSurveysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeiwCompletedSurveysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

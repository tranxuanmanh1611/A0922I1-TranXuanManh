import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularCountdownTimerComponent } from './angular-countdown-timer.component';

describe('AngularCountdownTimerComponent', () => {
  let component: AngularCountdownTimerComponent;
  let fixture: ComponentFixture<AngularCountdownTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularCountdownTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularCountdownTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

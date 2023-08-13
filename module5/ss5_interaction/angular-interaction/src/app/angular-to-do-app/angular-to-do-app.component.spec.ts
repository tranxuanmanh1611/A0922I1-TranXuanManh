import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularToDoAppComponent } from './angular-to-do-app.component';

describe('AngularToDoAppComponent', () => {
  let component: AngularToDoAppComponent;
  let fixture: ComponentFixture<AngularToDoAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularToDoAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularToDoAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

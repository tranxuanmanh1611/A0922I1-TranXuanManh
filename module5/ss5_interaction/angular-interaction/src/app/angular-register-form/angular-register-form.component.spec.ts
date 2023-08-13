import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularRegisterFormComponent } from './angular-register-form.component';

describe('AngularRegisterFormComponent', () => {
  let component: AngularRegisterFormComponent;
  let fixture: ComponentFixture<AngularRegisterFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularRegisterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularProcessBarComponent } from './angular-process-bar.component';

describe('AngularProcessBarComponent', () => {
  let component: AngularProcessBarComponent;
  let fixture: ComponentFixture<AngularProcessBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularProcessBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularProcessBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

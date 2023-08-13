import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AngularNameCardComponent } from './angular-name-card/angular-name-card.component';
import { NameCardComponent } from './angular-name-card/name-card/name-card.component';
import { AngularProcessBarComponent } from './angular-process-bar/angular-process-bar.component';
import { ProcessBarComponent } from './angular-process-bar/process-bar/process-bar.component';
import { AngularRatingComponent } from './angular-rating/angular-rating.component';
import { RatingBarComponent } from './angular-rating/rating-bar/rating-bar.component';
import { AngularCountdownTimerComponent } from './angular-countdown-timer/angular-countdown-timer.component';
import { AngularToDoAppComponent } from './angular-to-do-app/angular-to-do-app.component';
import { TodoComponent } from './angular-to-do-app/todo/todo.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AngularRegisterFormComponent } from './angular-register-form/angular-register-form.component';
import { AngularLoginComponent } from './angular-login/angular-login.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularNameCardComponent,
    NameCardComponent,
    AngularProcessBarComponent,
    ProcessBarComponent,
    AngularRatingComponent,
    RatingBarComponent,
    AngularCountdownTimerComponent,
    AngularToDoAppComponent,
    TodoComponent,
    AngularRegisterFormComponent,
    AngularLoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

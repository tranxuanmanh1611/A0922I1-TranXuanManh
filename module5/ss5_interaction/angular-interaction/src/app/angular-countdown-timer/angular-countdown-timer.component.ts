// import {Component, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';


@Component({
  selector: 'app-angular-countdown-timer',
  templateUrl: './angular-countdown-timer.component.html',
  styleUrls: ['./angular-countdown-timer.component.css']
})
export class AngularCountdownTimerComponent implements OnInit {
  time: number = 5;
  remainTime: number;
  private intervalID = 0;

  start() {
    this.intervalID = window.setInterval(() => {
      this.remainTime -= 1
      if (this.remainTime === 0) {
        this.pause();
      }
    }, 1000);
  }

  pause() {
    clearInterval(this.intervalID)
  }

  replay() {
    this.pause();
    this.remainTime=this.time;
  }

  constructor() {
  }

  ngOnInit(): void {
    this.remainTime=this.time;
  }

}

import {Component, Injectable, OnInit} from '@angular/core';
import {DateUtilServiceService} from './date-util-service.service';


@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css'],
  providers: [DateUtilServiceService]
})

export class TimelinesComponent implements OnInit {
  output = '';
  constructor(private dateUtilService: DateUtilServiceService) { }

  ngOnInit(): void {
  }
  onChange(value: string): void {
   this.output = this.dateUtilService.getDifferenceWithNow(value);
  }
}

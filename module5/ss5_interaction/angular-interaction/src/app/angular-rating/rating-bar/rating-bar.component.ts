import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {IRatingUnit} from "../irating-unit";

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit, OnChanges {
  max: number = 10;
  ratingValue: number = 5;
  ratingUnits: Array<IRatingUnit> = [];


  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnInit(): void {
    this.calculateDisplayedRatingUnit(this.max,this.ratingValue);
  }
  calculateDisplayedRatingUnit(max,ratingValue) {
    this.ratingUnits = Array.from({length:max},
      (_,index) => ({
        value:index+1,
        active: index<ratingValue
      }))
  }

  whenMouseEnter(currentPosition){
    this.ratingUnits.forEach((unit,index)=> unit.active= index<=currentPosition);
  }
  whenMouseLeave(){
    this.ratingUnits.forEach((unit,index)=> unit.active= index<this.ratingValue);
  }
  select(currentPosition){
    this.ratingValue = currentPosition+1;
  }
}

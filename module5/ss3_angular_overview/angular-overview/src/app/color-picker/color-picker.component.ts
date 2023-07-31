import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  color:string="black";
  pink():void{
    this.color="pink";
  }
  green():void{
    this.color="green";
  }
  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {Calculator} from "./calculator";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
calculator: Calculator = {
  result:0,
  firstOperand:0,
  secondOperand:0

}
plus(): void{
  this.calculator.result = this.calculator.firstOperand+this.calculator.secondOperand;
}
minus():void{
  this.calculator.result = this.calculator.firstOperand-this.calculator.secondOperand;
}
multiple():void{
  this.calculator.result = this.calculator.firstOperand*this.calculator.secondOperand;
}
divide():void{
  this.calculator.result = this.calculator.firstOperand/this.calculator.secondOperand;
}
  constructor() { }

  ngOnInit(): void {
  }

}

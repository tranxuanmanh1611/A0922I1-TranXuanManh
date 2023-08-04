import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-process-bar',
  templateUrl: './process-bar.component.html',
  styleUrls: ['./process-bar.component.css']
})
export class ProcessBarComponent implements OnInit {
  @Input() backgroundColor: string = '#D9D9D9';
  @Input() processColor:string = '#4CAF50';
  @Input() process:number;

  constructor() { }

  ngOnInit(): void {
    this.loading();
  }
  loading(){
    let interval = setInterval (()=> {
      this.process = +this.process+ 5;
      if (this.process == 100) {
        clearInterval(interval);
      }
    },1000);
  }
}

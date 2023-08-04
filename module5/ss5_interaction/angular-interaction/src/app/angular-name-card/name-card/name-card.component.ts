import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.css']
})
export class NameCardComponent implements OnInit {
  @Input() nameCard:String;
  @Input() email:String;
  @Input() phone:String;
  constructor() { }

  ngOnInit(): void {
  }

}

import {Component, Input, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.css']
})
export class NameCardComponent implements OnInit {
 /* @Input()*/ nameCard:string;
  /*@Input()*/ email:string;
 /* @Input()*/ phone:string;
  constructor() { }

  ngOnInit(): void {
    this.nameCard="TRAN XUAN MANH";
    this.email="abc@codegym.com.vn";
    this.phone="0999999999";
  }
 changeNameCard(form){
    console.log(form)
    this.nameCard = form.value.nameCard;
    this.email = form.value.email;
    this.phone = form.value.phone;
 }
}

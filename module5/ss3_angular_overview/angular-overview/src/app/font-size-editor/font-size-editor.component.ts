import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-font-size-editor',
  templateUrl: './font-size-editor.component.html',
  styleUrls: ['./font-size-editor.component.css']
})
export class FontSizeEditorComponent implements OnInit {
  fontSize = 14;
  textColor="red";
  // changeFontSizeValue(fontSize):void{
  //   this.fontSize=fontSize;
  // }
  constructor() { }

  ngOnInit(): void {
  }

}

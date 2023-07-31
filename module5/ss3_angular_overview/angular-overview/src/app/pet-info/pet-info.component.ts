import { Component, OnInit } from '@angular/core';
import {Pet} from "./pet";

@Component({
  selector: 'app-pet-info',
  templateUrl: './pet-info.component.html',
  styleUrls: ['./pet-info.component.css']
})
export class PetInfoComponent implements OnInit {
   pet: Pet = {
    name:'Pikachu',
    image:'https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg'
  };
  constructor() { }

  ngOnInit(): void {

  }

}

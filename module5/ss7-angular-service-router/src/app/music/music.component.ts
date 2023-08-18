import { Component, OnInit } from '@angular/core';
import {SongService} from './service/song.service';
import {Song} from './song';
import {ActivatedRoute} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css']
})
export class MusicComponent implements OnInit {

  constructor(
  ) { }

  ngOnInit(): void {
  }
}

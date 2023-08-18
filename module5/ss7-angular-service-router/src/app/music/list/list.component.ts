import { Component, OnInit } from '@angular/core';
import {Song} from '../song';
import {SongService} from '../service/song.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  playlist: Song[] = [];
  constructor(private songService: SongService) { }

  ngOnInit(): void {
    this.playlist = this.songService.getAll();
  }
}

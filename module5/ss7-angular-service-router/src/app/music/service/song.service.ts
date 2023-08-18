import {Injectable, OnInit} from '@angular/core';
import {Song} from '../song';

@Injectable({
  providedIn: 'root'
})
export class SongService{
  playlist: Song[] = [
    {
      id: '8bEV8U5xw3c',
      name: 'Akuma no Ko instrumental'
    },
    {
      id: 'SX_ViT4Ra7k',
      name: 'Lemon'
    }
  ];
  constructor() { }
  findSongById(id: string): Song  {
    return this.playlist.find(song =>  song.id === id);
  }
  getAll(): Song[]   {
    return this.playlist;
  }
}

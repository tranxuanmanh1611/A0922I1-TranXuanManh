import { Component, OnInit } from '@angular/core';
import {WordServiceService} from '../service/word-service.service';
import {IWord} from '../model/iword';

@Component({
  selector: 'app-word-list',
  templateUrl: './word-list.component.html',
  styleUrls: ['./word-list.component.css']
})
export class WordListComponent implements OnInit {
  words: IWord[];
  constructor(private wordService: WordServiceService) { }

  ngOnInit(): void {
  }
  searchWord(value: string) {
    this.words = this.wordService.findByWord(value);

  }
}

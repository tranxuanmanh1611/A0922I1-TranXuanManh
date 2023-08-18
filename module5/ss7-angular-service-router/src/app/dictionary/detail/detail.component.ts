import { Component, OnInit } from '@angular/core';
import {WordServiceService} from '../service/word-service.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {IWord} from '../model/iword';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  selectedWord: IWord;
  constructor(private wordService: WordServiceService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const wordIndex = Number(paramMap.get('id'));
      this.selectedWord = this.wordService.findById(wordIndex);
    });
  }

}

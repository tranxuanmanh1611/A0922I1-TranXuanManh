import { Injectable } from '@angular/core';
import {IWord} from '../model/iword';
import {element} from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class WordServiceService {
private words: IWord[] = [
  {
    id: 1,
    word: 'Operating system',
    mean: '/ˈɒpəreɪtɪŋ ˈsɪstɪm/ (n): hệ điều hành'
  },
  {
    id: 2,
    word: 'Multi-user',
    mean: '/ˈmʌltɪ-ˈjuːzə/ (n) đa người dùng\n'
  },
  {
    id: 3,
    word: 'Gateway',
    mean: '/ˈɡeɪtweɪ/ (n): cổng kết nối Internet cho những mạng lớn'
  },
  {
    id: 4,
    word: 'Packet',
    mean: '/ ˈpækɪt/ (n): gói dữ liệu'
  },
  {
    id: 5,
    word: 'Source code ',
    mean: '/sɔːs kəʊd/ (n): mã nguồn (của của file hay một chương trình nào đó)'
  }
];
  constructor() { }
  getAll() {
    return this.words;
  }
  findById(id: number) {
    return this.words.find(word => word.id === id);
  }
  findByWord(input: string) {
    return this.words.filter(
      (word: IWord) => word.word.toLowerCase().includes(input.toLowerCase())
    );
  }
}

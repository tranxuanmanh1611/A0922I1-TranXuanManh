import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly URL_API = 'http://localhost:3001/categories';
  constructor(private httpService: HttpClient) { }
  getAll() {
    return this.httpService.get<Category[]>(this.URL_API);
  }
}

import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly URL_API = 'http://localhost:3000/products';
  constructor(private httpService: HttpClient) {}
  getAll() {
    return this.httpService.get<Product[]>(this.URL_API);
  }
  findById(productId: number) {
    return this.httpService.get<Product>(`${this.URL_API}/${productId}`);
  }
  saveProduct(product: Product) {
    return this.httpService.patch<Product>(`${this.URL_API}/${product.id}`, product);
  }
  newProduct(product: Partial<Product>) {
    console.log(product);
    return this.httpService.post(this.URL_API, product);
  }
  deleteProduct(id: number) {
    return this.httpService.delete<Product>(this.URL_API + '/' + id);
  }
}

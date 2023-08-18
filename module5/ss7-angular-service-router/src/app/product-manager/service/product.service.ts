import { Injectable } from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];
  constructor() { }
  getAll() {
    return this.products;
  }
  addProduct(product: Product) {
    this.products.unshift(product);
  }
  findById(id: number) {
    return this.products.find(element => id === element.id);
  }
  edit(product: Product) {
    const productToEdit: Product = this.products.find(element => Number(product.id) === element.id);
    productToEdit.name = product.name;
    productToEdit.price = Number(product.price);
    productToEdit.description = product.description;
  }
  delete(productId: any) {
    const productIndexToDelete = this.products.findIndex(element => productId === element.id);
    this.products.splice(productIndexToDelete, 1);
  }
}

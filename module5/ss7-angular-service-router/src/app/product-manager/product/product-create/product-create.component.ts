import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../model/product';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';
import {ProductListComponent} from '../product-list/product-list.component';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
productToAdd: Partial<Product>;
categories: Category[] = [];
  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router,
              private categoryService: CategoryService) {
    this.categoryService.getAll().subscribe(
      next => this.categories = next,
      error => console.log(error),
      () => {
        this.productForm = this.formBuilder.group(
          {
            id: this.formBuilder.control(''),
            name: this.formBuilder.control(''),
            price: this.formBuilder.control(''),
            description: this.formBuilder.control(''),
            categoryId: this.formBuilder.control('')
          }
        );
      }
    );
  }
  ngOnInit(): void {
  }
  save() {
    console.log(this.productForm);
    this.productToAdd = {
      id: Number(this.productForm.value.id),
      name: this.productForm.value.name,
      price: Number(this.productForm.value.price),
      description: this.productForm.value.description,
      category: this.categories.find(category => category.id === Number(this.productForm.value.categoryId))
    };
    this.productService.newProduct(this.productToAdd).subscribe(
      next => {
        this.router.navigateByUrl('product-manager');
      }
    );
  }
}

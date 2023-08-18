import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
productToAdd: Product;
  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router) {
    this.productForm = formBuilder.group(
      {
        id: [''],
        name: [''],
        price: [''],
        description: ['']
      }
    );
  }
  ngOnInit(): void {
  }
  save() {
    this.productToAdd = {
      id: Number(this.productForm.value.id),
      name: this.productForm.value.name,
      price: Number(this.productForm.value.price),
      description: this.productForm.value.description
    };
    this.productService.addProduct(this.productToAdd);
    this.router.navigateByUrl('product-manager');
  }
}

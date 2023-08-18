import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;

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
    this.productService.addProduct(this.productForm.value);
    this.router.navigateByUrl('product-manager');
  }
}

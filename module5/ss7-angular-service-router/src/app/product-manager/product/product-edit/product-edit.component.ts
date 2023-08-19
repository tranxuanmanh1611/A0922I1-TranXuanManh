import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productToEdit: Product;
  productForm: FormGroup;
  categories: Category[] = [];

  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const productId = Number(paramMap.get('id'));
      this.categoryService.getAll().subscribe(
        next => this.categories = next
      );
      this.productService.findById(productId).subscribe(
        next => this.productToEdit = next,
        error => console.log(error),
        () => {
          this.productForm = this.formBuilder.group(
            {
              id: this.formBuilder.control(this.productToEdit.id),
              name: this.formBuilder.control(this.productToEdit.name),
              price: this.formBuilder.control(this.productToEdit.price),
              description: this.formBuilder.control(this.productToEdit.description),
              categoryId: this.formBuilder.control(this.productToEdit.category.id)
            }
          );
        }
      );
    });
  }

  save() {
    this.productToEdit.id = Number(this.productForm.value.id);
    this.productToEdit.name = this.productForm.value.name;
    this.productToEdit.price = Number(this.productForm.value.price);
    this.productToEdit.description = this.productForm.value.description;
    const categoryId = Number(this.productForm.value.categoryId);

    this.productToEdit.category = this.categories.find(category => category.id === categoryId);
    this.productService.saveProduct(this.productToEdit).subscribe(
      next => this.router.navigateByUrl('/product-manager')
    );
  }
}

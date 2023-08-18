import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
    selector: 'app-product-edit',
    templateUrl: './product-edit.component.html',
    styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

    productToEdit: Product;
    productForm: FormGroup;

    constructor(private formBuilder: FormBuilder,
                private productService: ProductService,
                private router: Router,
                private activatedRoute: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
            const productId = paramMap.get('id');
            this.productToEdit = this.productService.findById(Number(productId));
        });
        this.productForm = this.formBuilder.group(
            {
                id: this.formBuilder.control(this.productToEdit.id),
                name: this.formBuilder.control(this.productToEdit.name),
                price: this.formBuilder.control(this.productToEdit.price),
                description: this.formBuilder.control(this.productToEdit.description)
            }
        );
    }

    save() {
        this.productService.edit(this.productForm.value);
        this.router.navigateByUrl('product-manager');
    }

}

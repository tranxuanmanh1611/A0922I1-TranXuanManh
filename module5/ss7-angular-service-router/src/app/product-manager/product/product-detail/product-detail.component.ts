import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  sub: Subscription;
  product: Product;
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    console.log('get in the OnInit');
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const productId = Number(paramMap.get('id'));
      this.productService.findById(productId).subscribe(
        next => this.product = next
      );
    });
  }
  delete(id: number) {
    this.productService.deleteProduct(id).subscribe(
      next => this.router.navigateByUrl('product-manager')
    );
  }
}

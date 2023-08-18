import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Routes} from '@angular/router';
import {Product} from '../../model/product';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  sub: Subscription;
  product: Product = null;
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    console.log('get in the OnInit');
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const productId = paramMap.get('id');
      this.product = this.productService.findById(Number(productId));
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}

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
export class ProductDetailComponent implements OnInit, OnDestroy {
  sub: Subscription;
  product: Product = null;
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    console.log('get in the OnInit');
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const productId = Number(paramMap.get('id'));
      console.log(typeof productId);
      this.product = this.productService.findById(Number(productId));
      console.log(this.product);
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
  delete(id: number) {
    this.productService.delete(id);
    this.router.navigateByUrl('product-manager');
  }
}

import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';
import {PlayerComponent} from './music/player/player.component';
import {ListComponent} from './music/list/list.component';
import {ProductListComponent} from './product-manager/product/product-list/product-list.component';
import {ProductCreateComponent} from './product-manager/product/product-create/product-create.component';
import {ProductDetailComponent} from './product-manager/product/product-detail/product-detail.component';
import {ProductEditComponent} from './product-manager/product/product-edit/product-edit.component';
import {WordListComponent} from './dictionary/word-list/word-list.component';
import {DetailComponent} from './dictionary/detail/detail.component';
import {TodoComponent} from './todo/todo/todo.component';

const routes: Routes = [
  {
    path: 'to-do-list',
    component: TodoComponent
  },
  {
    path: 'timelines',
    component: TimelinesComponent
  },
  {
    path: 'musics',
    component: ListComponent,
    children: [
      {
        path: ':id',
        component: PlayerComponent
      }
    ]
  },
  {
    path: 'product-manager',
    component: ProductListComponent,
    children: [
      {
        path: 'list/:id',
        component: ProductDetailComponent
      },
      {
        path: 'edit/:id',
        component: ProductEditComponent
      }
    ]
  },
  {
    path: 'new',
    component: ProductCreateComponent
  },
  {
    path: 'dictionary',
    component: WordListComponent,
    children: [
      {
        path: ':id',
        component: DetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
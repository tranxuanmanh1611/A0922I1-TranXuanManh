import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelinesComponent } from './timelines/timelines.component';
import { MusicComponent } from './music/music.component';
import { ListComponent } from './music/list/list.component';
import { PlayerComponent } from './music/player/player.component';
import { ProductManagerComponent } from './product-manager/product-manager.component';
import { ProductListComponent } from './product-manager/product/product-list/product-list.component';
import { ProductCreateComponent } from './product-manager/product/product-create/product-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProductDetailComponent } from './product-manager/product/product-detail/product-detail.component';
import {ProductEditComponent} from './product-manager/product/product-edit/product-edit.component';
import { WordListComponent } from './dictionary/word-list/word-list.component';
import { DetailComponent } from './dictionary/detail/detail.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    MusicComponent,
    ListComponent,
    PlayerComponent,
    ProductManagerComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductDetailComponent,
    ProductEditComponent,
    WordListComponent,
    DetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

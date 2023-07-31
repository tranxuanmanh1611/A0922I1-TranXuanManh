import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import {FormsModule} from "@angular/forms";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListComponent } from './product-list/product-list.component';
import { PetInfoComponent } from './pet-info/pet-info.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { HackerNewsComponent } from './hacker-news/hacker-news.component';
import { LikeComponent } from './hacker-news/like/like.component';
import { NavBarComponent } from './hacker-news/nav-bar/nav-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    ProductListComponent,
    PetInfoComponent,
    CalculatorComponent,
    ColorPickerComponent,
    HackerNewsComponent,
    LikeComponent,
    NavBarComponent,
  ],
    imports: [
        BrowserModule,
        FormsModule,
        NgbModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

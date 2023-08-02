import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { ServiceEditComponent } from './service-edit/service-edit.component';
import { ServiceNewComponent } from './service-new/service-new.component';
import { HeaderComponent } from './header/header.component';
import { LeftPanelComponent } from './left-panel/left-panel.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { CustomerNewComponent } from './customer-new/customer-new.component';

@NgModule({
  declarations: [
    AppComponent,
    ServiceListComponent,
    ServiceEditComponent,
    ServiceNewComponent,
    HeaderComponent,
    LeftPanelComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerNewComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

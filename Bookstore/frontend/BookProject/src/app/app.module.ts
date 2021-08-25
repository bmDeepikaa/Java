import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookInsertComponent } from './book-insert/book-insert.component';
import { BookInfoComponent } from './book-info/book-info.component';
import { BookUpdateComponent } from './book-update/book-update.component';


@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    routingComponents,
    BookInsertComponent,
    BookInfoComponent,
    BookUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  FormsModule,
  HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookInfoComponent } from './book-info/book-info.component';
import { BookInsertComponent } from './book-insert/book-insert.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookUpdateComponent } from './book-update/book-update.component';


let routes:Routes=
[
  {path:'books', component:BookListComponent},
  {path:'create', component:BookInsertComponent},
  {path:'update/:isbn', component:BookUpdateComponent},
  {path:'info/:isbn', component:BookInfoComponent},



  



]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export let routingComponents=[BookListComponent,BookInsertComponent,BookUpdateComponent,BookInfoComponent]

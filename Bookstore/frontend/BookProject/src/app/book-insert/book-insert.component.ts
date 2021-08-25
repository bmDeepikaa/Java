import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-insert',
  templateUrl: './book-insert.component.html',
  styleUrls: ['./book-insert.component.css']
})
export class BookInsertComponent implements OnInit {
book:Book =new Book();
bookDB:any;
serial:any;
author:any;
year:any;
price:any;
  constructor(private bookService:BookService,private router:Router) { }

  ngOnInit(): void {
  }
// checkSerial(){
//   this.bookService.insertBookbySerial(this.book).subscribe(data=>{
//     console.log(data,this.bookDB);
//     this.saveBook();
//   },   error=>console.log(error));

// }

  //call the method from sevice to post inserted data
  saveBook(){
    this.bookService.CreateBook(this.book).subscribe(data=>{
      console.log(data);
      this.goToBookList();
    },
    error=>console.log(error));
    
  }

   //navigate to the page that holds employees path
   goToBookList()
   {
 this.router.navigate(['/books']); 
   }
 
   //calls the save employess method upon clicking on it
 
   onSubmit(){
     console.log(this.book);
    //  this.checkSerial();
    this.saveBook();
   }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
books!:Book[];
  constructor(private bookService:BookService,private router:Router) { }

  ngOnInit(): void {
   //FOR THE METHOD TO BE USED/INITIALZED
   this.getBooks();
  }

  //CALL THE LIST OF DATA USING THE GETBOOKLIST FROM SERVICE
  private getBooks(){
    this.bookService.getBookList()
    .subscribe(data=>
      {
        this.books=data;
      })
  }

  //NAVIGATE THE PAGE TO UPDATE PAGE WHEN CLICK ON THE BUTOTNN BRING THE ID OF THE book TO UPDATE TO THE UPDATE PAGE TO DISPLAY
  updateBookPage(isbn:number){
    this.router.navigate(['update',isbn]);
  }

  deleteBook(isbn:number)
  {
    this.bookService.deleteBook(isbn).subscribe(data=>{
      console.log(data);
      this.getBooks();
    });
  }
}

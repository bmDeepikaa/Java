import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {
book:Book= new Book();
isbn!:number;
  constructor(private bookService:BookService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.isbn = this.route.snapshot.params['isbn'];

    this.bookService.getbookByIsbn(this.isbn).subscribe(data=>{
this.book=data;
    },error=>console.log(error)
    );
  }

   //UPON CLICKING ON THE SUBMIT BUTTON THE SERVICE UPDATE EMPLOYEE IS CALED AND PUTS THE DATA INSIDE DB.
   onSubmit(){
     
    this.bookService.updateBook(this.isbn,this.book)
    .subscribe(data=>
      {
        //CAL THIS METHOD TO NAVIGATE TO THE PAGE WHEN SUCCESSFUL
        this.goToBookList();
      },error=>console.group(error));
    
}

//NAVIGATE TO THE HOME PAGE AFTER UPDATE IS SUCCESSFUL
goToBookList()
{
this.router.navigate(['/books']); 
}

}

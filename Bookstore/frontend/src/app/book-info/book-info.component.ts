import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-info',
  templateUrl: './book-info.component.html',
  styleUrls: ['./book-info.component.css']
})
export class BookInfoComponent implements OnInit {
book!:Book;
isbn!:any;
  constructor(private route:ActivatedRoute,private bookService:BookService,private router:Router) { }

  ngOnInit(): void {
    this.isbn = this.route.snapshot.params['isbn'];

    
    this.bookService.getbookByIsbn(this.isbn).subscribe(data=>{
      this.book=data;
          },error=>console.log(error)
          );
  }


  goBack(){
this.router.navigate(['books']);
  }

}

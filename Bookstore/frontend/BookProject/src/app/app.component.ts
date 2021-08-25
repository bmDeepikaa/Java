import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from './book';
import { BookService } from './book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookProject';
  book:Book=new Book();
bookDB:any;
isbn!:number;
  constructor(private bookService:BookService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    // this.isbn = this.route.snapshot.params['isbn'];

  }
  //call the method from sevice to post inserted data
  checkTitle(){
    this.bookService.getBookByTitle(this.book).subscribe(data=>{
      console.log(data,this.bookDB);
      console.log("SUCCESS");
      // this.goToBookInfo(this.isbn);
    },   error=>console.log(error));
  }
  onSearch(){
    this.checkTitle();

  }
//   goToBookInfo(isbn:number)
//   {
//  this.router.navigate(['info',isbn]); 
//   }
checkId(){
this.bookService.getbookByIsbn(this.isbn).subscribe(data=>{
  this.book=data;
      },error=>console.log(error)
      );
}
}
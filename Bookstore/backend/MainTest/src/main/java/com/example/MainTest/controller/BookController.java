package com.example.MainTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MainTest.exception.ResourceNotFoundException;
import com.example.MainTest.model.Book;
import com.example.MainTest.service.BookRepo;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	public BookRepo br;


	//INSERT DATA
	@PostMapping("/books")
	public Book insert(@RequestBody Book book)
	{
//		
		return br.save(book);
	}

	//GET ALL DATA FROM books
	@GetMapping("/books")
	public List<Book> findAllBook()
	{
		return  (List<Book>) br.findAll();
	}
	
	//GET book by title
			@PostMapping("/books/title")
			//NO PATH VARIABLE SO WE NOT USING VARIABLE IN THIS METHOD
			public ResponseEntity<Book> getBookByTitle( @RequestBody Book bc) { //OBJECT IOF USER ENTERED
				List<Book>BOOK= findAllBook(); //call the list all books
				Book b =new Book(); // crete object for books
				//loop thru the books the to veriy the tite
				for(Book book:BOOK) {
					
					if(book.getTitle().equals(bc.getTitle())) {
						
							 b= br.findById(book.getIsbn()) //if bookk title  is same as one in db call the id 
									.orElseThrow(() -> new ResourceNotFoundException("book does not exist with id :" +book.getIsbn()));
							
						
						
					}
				}
				
				return ResponseEntity.ok(b); //return the row of data w the id aftre checking
			}
			
			
			//GET EMP BY ISBN
			@GetMapping("/books/{isbn}")
			public ResponseEntity<Book> getEmployeeById(@PathVariable int isbn) {
				Book book= br.findById(isbn)
						.orElseThrow(() -> new ResourceNotFoundException("book not exist with id :" + isbn));
				return ResponseEntity.ok(book);
			}
			
			
			//UPDATE THE VENDOR NAME DOB AND PASSWORD
			@PutMapping("/books/{isbn}")
			public ResponseEntity<Book> updateBook(@PathVariable int isbn, @RequestBody Book BookDetail){
						Book b = br.findById(isbn)

						.orElseThrow(() -> new ResourceNotFoundException("BOOK DOES NOT exist with id :" + isbn));

				if(BookDetail.getSerial()==(b.getSerial())) {
System.out.println("serial same");
				
				}
				b.setSerial(BookDetail.getSerial());

				Book updatedBook = br.save(b);
				return ResponseEntity.ok(updatedBook);
				
			}	
			
			
			//DELETE BOOK BASED ON THE ISBN
			@DeleteMapping("/books/{isbn}")
			public List<Book> deleteBook(@PathVariable int isbn)
			{
				br.deleteById(isbn);
				return (List<Book>) br.findAll();
				
			}
			
		
			//post using unique serial number/isbn
//			@PostMapping("/books/serial")
//			//NO PATH VARIABLE SO WE NOT USING VARIABLE IN THIS METHOD
//			public ResponseEntity<Book> insertBookbySerial( @RequestBody Book bc) { //OBJECT IOF USER ENTERED
//				List<Book>BOOK= findAllBook(); //call the list all books
//				Book b =new Book(); // crete object for books
//				//loop thru the books the to veriy the tite
//				for(Book book:BOOK) {
//					
//					if(book.getSerial()==(bc.getSerial())) {
//						
//							 b= br.findById(book.getIsbn()) //if bookk title  is same as one in db call the id 
//									.orElseThrow(() -> new ResourceNotFoundException("book exists with serial :" +book.getSerial()));
//								return ResponseEntity.ok(bc);
//				
//				}
//					
//				
//			}
//				return (ResponseEntity<Book>) BOOK; //return the row of data w the id aftre checking
//
//	
//	
//			}
			}

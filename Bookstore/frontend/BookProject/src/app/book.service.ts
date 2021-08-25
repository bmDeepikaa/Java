import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Book } from './book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  books: any = [];
  private baseURL = "http://localhost:8086/api/books";
  constructor(private httpClient: HttpClient) { }

  
  getBookList(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(`${this.baseURL}`)
  }

  CreateBook(book:Book): Observable<any> {
    return this.httpClient.post(`${this.baseURL}`, book)
  }

  getBookByTitle(book:Book):Observable<any> {
    return this.httpClient.post<Book>(`${this.baseURL}/title`,book);
  }

  getbookByIsbn(isbn: number): Observable<Book> {
    return this.httpClient.get<Book>(`${this.baseURL}/${isbn}`);
  }
  insertBookbySerial(book:Book):Observable<any> {
    return this.httpClient.post<Book>(`${this.baseURL}/serial`,book);
  }
  updateBook(isbn: number, book:Book): Observable<any>
  {
    return this.httpClient.put(`${this.baseURL}/${isbn}`, book);
  }
  deleteBook(isbn: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${isbn}`);

  }

}

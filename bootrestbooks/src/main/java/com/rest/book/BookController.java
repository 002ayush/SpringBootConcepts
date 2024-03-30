package com.rest.book;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.rest.book.entities.Book;
import com.rest.book.services.BookServices;

@RestController
public class BookController {
	@Autowired
	private BookServices bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getallBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id) {
		Book book = this.bookService.getSingleBook(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		
		b = this.bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
			
		}
			
	
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid) {
		
			this.bookService.deleteBook(bookid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookid") int bookid) {
			
				this.bookService.updateBook(book, bookid);
				return ResponseEntity.of(Optional.of(book));
			
		}
	
}

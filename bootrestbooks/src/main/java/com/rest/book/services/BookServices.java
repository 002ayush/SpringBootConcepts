package com.rest.book.services;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.book.dao.BookRepository;
import com.rest.book.entities.Book;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
	/*private static List<Book> list = new ArrayList<>();
	 static {
		list.add(new Book(12,"Java Programming","Ayush"));
		list.add(new Book(13,"Python Programming","Shayam"));
		list.add(new Book(14,"C# Programming","Tomar"));
	}*/
	 public List<Book> getallBooks(){
		 List<Book> list = (List<Book>) this.bookRepository.findAll();
		 return list;
	 }
	 public Book getSingleBook(int id) {
		Book book = this.bookRepository.findById(id);
		return book;
	 }
	 public Book addBook(Book book) {
		 Book books = this.bookRepository.save(book);
		 return book;
		 
	 }
	 public void deleteBook(int bookId) {
		 this.bookRepository.deleteById(bookId);
	 }
	 public void updateBook(Book b,int bookid)
	 {
		b.setId(bookid);
		this.bookRepository.save(b);
	 }
}

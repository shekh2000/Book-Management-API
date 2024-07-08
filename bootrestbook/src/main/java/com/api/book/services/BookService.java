package com.api.book.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(1,"deepak","enjoy the journey"));
//		list.add(new Book(2,"joy","have fun"));
//		list.add(new Book(3,"sam","life become serious"));
//		list.add(new Book(4,"tint","number 1"));
//	}
	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAllBooks(){
		List<Book>list = (List<Book>)this.bookRepo.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book = bookRepo.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public void addBook(Book book) {
		bookRepo.save(book);
		return ;
	}
	
	public void deleteBook(int id) {
//		list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		bookRepo.deleteById(id);
		return ;
	}
	public void updateBook(Book book,int id) {
//		list = list.stream().map(e->{
//			if(e.getId()==id)return book;
//			else
//			return e;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepo.save(book);
		return ;
	}
}

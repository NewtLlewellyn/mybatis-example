package com.github.newtllewellyn.book;

import java.math.BigDecimal;

public class Book extends BookInterface {
	private String isbn;
	private String author;
	

	public Book(String uuid, String name, BigDecimal price, String press) {
		super(uuid, name, price, press);
		// TODO Auto-generated constructor stub
	}

	public Book(String uuid, String name, BigDecimal price, String press,
			String isbn, String author) {
		super(uuid, name, price, press);
		this.isbn = isbn;
		this.author = author;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getAuthor() {
		return this.author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}

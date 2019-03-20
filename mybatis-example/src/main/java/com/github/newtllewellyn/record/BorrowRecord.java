package com.github.newtllewellyn.record;

import java.util.Date;
import java.util.UUID;

import com.github.newtllewellyn.book.BookInterface;
import com.github.newtllewellyn.user.Student;



public class BorrowRecord {
	private String uuid;
	private Student student;
	private BookInterface book;
	private Date borrowDate;
	private Date returnDate;
	private int num;
	
	public BorrowRecord() {
		
	}
	
	public BorrowRecord(Student student, BookInterface book) {
		this.student = student;
		this.book  = book;
		this.uuid = UUID.randomUUID().toString();
		this.num = 1;
		this.borrowDate = new Date();
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setBook(BookInterface book) {
		this.book = book;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getUuid() {
		return uuid;
	}

	public Student getStudent() {
		return student;
	}

	public BookInterface getBook() {
		return book;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}
	
	
	
}

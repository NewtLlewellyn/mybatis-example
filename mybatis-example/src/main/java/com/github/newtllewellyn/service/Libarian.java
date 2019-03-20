package com.github.newtllewellyn.service;

import java.util.Date;

import com.github.newtllewellyn.book.BookInterface;
import com.github.newtllewellyn.record.RecordList;
import com.github.newtllewellyn.store.BookNotExistException;
import com.github.newtllewellyn.store.Store;
import com.github.newtllewellyn.user.Student;


public class Libarian {

	public BookInterface lend(Student student, BookInterface book) {
		Store store = Store.getInstance();
		Integer num = store.getNum(book);
		if (num == null)
			return null;
		else {
			try {
				store.absBook(book, 1);
				RecordList.getInstance().borrowBook(student, book);
			} catch (BookNotExistException e) {
				return null;
			}
		}
		return null;
	}

	public void returnBook(Student student, BookInterface book) {
		Store store = Store.getInstance();
		store.addBook(book, 1);
		RecordList.getInstance().returnBook(student, book);
	}

}

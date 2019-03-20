package com.github.newtllewellyn.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.newtllewellyn.book.BookInterface;


//为了存放数据，导致耦合性太强？

public class Store {
	private HashMap<BookInterface, Integer> stores;
	
	private static Store store;
	
	//单例程序设计方法
	public static Store getInstance() {
		if(store == null) {
			store = new Store();
		}
		return store;
	}
	
	private Store() {
		this.stores = new HashMap<BookInterface, Integer>();
	}

	public void addBook(BookInterface book, int num) {
		if (this.stores.containsKey(book)) {
			this.stores.put(book, this.stores.get(book) + num);
		} else
			this.stores.put(book, num);
	}

	public void absBook(BookInterface book, int num) throws BookNotExistException{
		if (this.stores.containsKey(book)) {
			this.stores.put(book, this.stores.get(book) - num);
		} else
			throw new BookNotExistException();
	}
	
	public Integer getNum(BookInterface book) {
		return this.stores.get(book);
	}
}

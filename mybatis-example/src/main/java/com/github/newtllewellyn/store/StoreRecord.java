package com.github.newtllewellyn.store;

import com.github.newtllewellyn.book.BookInterface;

public class StoreRecord {
	private BookInterface bi;
	private int bookNum;
	
	public StoreRecord() {}
	
	public StoreRecord(BookInterface bi, int bookNum) {
		this.bi = bi;
		this.bookNum = bookNum;
	}

	public BookInterface getBi() {
		return bi;
	}
	
	
	
	public void setBi(BookInterface bi) {
		this.bi = bi;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	
	
}

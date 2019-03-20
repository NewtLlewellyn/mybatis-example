package com.github.newtllewellyn.record;

import java.util.Date;
import java.util.HashMap;

import com.github.newtllewellyn.book.BookInterface;
import com.github.newtllewellyn.user.Student;



public class RecordList {

	private static RecordList reclist;

	class CompoundKey {
		private Student student;
		private BookInterface book;
		
		public CompoundKey(Student student, BookInterface book) {
			this.book = book;
			this.student = student;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((book == null) ? 0 : 
				book.hashCode());
			result = prime * result + ((student == null) ? 0 : 
				student.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CompoundKey other = (CompoundKey) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (book == null) {
				if (other.book != null)
					return false;
			} else if (!book.equals(other.book))
				return false;
			if (student == null) {
				if (other.student != null)
					return false;
			} else if (!student.equals(other.student))
				return false;
			return true;
		}

		private RecordList getEnclosingInstance() {
			return RecordList.this;
		}

	}

	private HashMap<CompoundKey, BorrowRecord> recordList = 
			new HashMap<CompoundKey, BorrowRecord>();

	public static RecordList getInstance() {
		if (reclist == null) {
			reclist = new RecordList();
		}
		return reclist;
	}

	private RecordList() {

	}

	public static RecordList getReclist() {
		return reclist;
	}

	public static void setReclist(RecordList reclist) {
		RecordList.reclist = reclist;
	}

	public HashMap<CompoundKey, BorrowRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(HashMap<CompoundKey, BorrowRecord> recordList) {
		this.recordList = recordList;
	}

	public void returnBook(Student student, BookInterface book) {
		CompoundKey key = new CompoundKey(student, book);
		recordList.get(key).setReturnDate(new Date());
	}

	public void borrowBook(Student student, BookInterface book) {
		CompoundKey key = new CompoundKey(student, book);
		recordList.put(key, new BorrowRecord(student, book));
	}

}

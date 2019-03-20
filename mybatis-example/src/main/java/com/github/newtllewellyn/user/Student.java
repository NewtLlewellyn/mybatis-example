package com.github.newtllewellyn.user;

import com.github.newtllewellyn.book.Book;

public class Student {
	private String id = "1";
	private String name = "name";
	//private int age = 18;
	//private double score = 10.12;
	//private float as = 2.2f;
	//private long we = 10L;
	//private char sex = 'm';

	public String getId() {
		return this.id;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return this.name;
	}

//	public void setScore(double score) {
//		this. = score;
//	}
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		StudentInfo s = new StudentInfo();
//		System.out.println(s.getScore());
//		s.setScore(6.9);
//		System.out.println(s.getScore());
//
//		Book b = new Book();
//		int i = 10;
//		b.f(i);
		
	}

}

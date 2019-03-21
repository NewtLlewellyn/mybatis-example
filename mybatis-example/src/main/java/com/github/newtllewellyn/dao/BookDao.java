package com.github.newtllewellyn.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.github.newtllewellyn.book.Book;
import com.github.newtllewellyn.book.BookInterface;
import com.github.newtllewellyn.book.Journal;

import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BookDao {
	@Insert("INSERT INTO book(bookid, bookname, author, price, "
			+ "isbn, press, vtype) VALUES(#{uuid}, #{name}, #{author}, " + "#{price}, #{isbn}, #{press}, 'book')")
	public void saveBook(Book book);

	@Results({
			@Result(id = true, column = "bookid", jdbcType = JdbcType.VARCHAR, property = "uuid", javaType = String.class),
			@Result(column = "bookname", jdbcType = JdbcType.VARCHAR, property = "name", javaType = String.class),
			@Result(column = "author", jdbcType = JdbcType.VARCHAR, property = "author", javaType = String.class),
			@Result(column = "price", jdbcType = JdbcType.DOUBLE, property = "price", javaType = BigDecimal.class),
			@Result(column = "isbn", jdbcType = JdbcType.VARCHAR, property = "isbn", javaType = String.class),
			@Result(column = "press", jdbcType = JdbcType.VARCHAR, property = "press", javaType = String.class),
			@Result(column = "editor", jdbcType = JdbcType.VARCHAR, property = "editor", javaType = String.class) })
	@ConstructorArgs(value = { @Arg(id = true, column = "bookid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Arg(column = "bookname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Arg(column = "price", javaType = BigDecimal.class, jdbcType = JdbcType.DOUBLE),
			@Arg(column = "press", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	@TypeDiscriminator(cases = { @Case(type = Book.class, value = "book"),
			@Case(type = Journal.class, value = "journal"),
			@Case(type = BookInterface.class, value = "absbook") }, column = "vtype")
	@Select("SELECT * FROM book WHERE bookid = #{uuid}")
	public BookInterface searchBookById(String uuid);

//	@Select("SELECT bookid, bookname, vtype, author, price, isbn, press FROM"
//			+ "book WHERE isbn=#{isbn}")
	@Select("SELECT * FROM " + "book WHERE isbn = #{isbn}")
	@Results({
			@Result(id = true, column = "bookid", jdbcType = JdbcType.VARCHAR, property = "uuid", javaType = String.class),
			@Result(column = "bookname", jdbcType = JdbcType.VARCHAR, property = "name", javaType = String.class),
			@Result(column = "author", jdbcType = JdbcType.VARCHAR, property = "author", javaType = String.class),
			@Result(column = "price", jdbcType = JdbcType.DOUBLE, property = "price", javaType = Double.class),
			@Result(column = "isbn", jdbcType = JdbcType.VARCHAR, property = "isbn", javaType = String.class),
			@Result(column = "press", jdbcType = JdbcType.VARCHAR, property = "press", javaType = String.class),
			@Result(column = "editor", jdbcType = JdbcType.VARCHAR, property = "editor", javaType = String.class) })
	@TypeDiscriminator(cases = { @Case(type = Book.class, value = "book"),
			@Case(type = Journal.class, value = "journal"),
			@Case(type = BookInterface.class, value = "absbook") }, column = "vtype")
	public BookInterface searchBook(String isbn);
	
	
	@Delete(value = { "DELETE FROM book WHERE bookid = #{bookid}" })
	public void deleteBook(String bookid);
	
	@Update("UPDATE book SET bookname = #{name}, author = #{author}, price = #{price}, isbn = #{isbn}, press = #{press} WHERE bookid = #{uuid}")
	public void updateBook(Book Book);
	
}
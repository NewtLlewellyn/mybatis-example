package com.github.newtllewellyn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.github.newtllewellyn.store.StoreRecord;

public interface StoreRecordDao {
	
	@Insert("INSERT INTO store(bookid, booknum) VALUES(#{bi.uuid}, "
			+ "#{sr.num})")
	public void saveStoreRecord(StoreRecord sr);
	
	
	@Results({
		@Result(property = "uuid", column = "bookid", id = true, 
				one = @One(select = "com.github.newtllewellyn.dao.BookDao"
				+ ".searchBookById"))
	})
	@Select("SELECT * FROM store WHERE bookid = #{uuid}")
	public StoreRecord searchStoreRecordById(String uuid);
}

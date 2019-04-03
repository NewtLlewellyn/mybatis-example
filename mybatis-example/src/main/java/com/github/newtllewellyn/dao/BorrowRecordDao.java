package com.github.newtllewellyn.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.github.newtllewellyn.record.BorrowRecord;


@Mapper
public interface BorrowRecordDao {

	@Insert("INSERT INTO recordlist(recid, bookid, stuid, borrowdate, "
			+ "returndate, borrownum) VALUES(#{uuid}, #{rec.book.uuid}, "
			+ "#{rec.student.uuid}, #{borrowDate}, #{returnDate}, #{num})")
	public void saveBorrowRecord(BorrowRecord rec);

	// @Result(column="sname",property="sname1")
	@Results({
			@Result(property = "uuid", column = "bookid", one = @One(select = "com.github.newtllewellyn.dao.BookDao"
					+ ".searchBookById")),
			@Result(property = "id", column = "stuid", one = @One(select = "com.github.newtllewellyn.dao.StudentDao"
					+ ".searchStudentById"))
			/*
			 * Fix this note!!! 根据@Select("select * from student where sid=#{0}")结果 把gid自动
			 * 映射到数据库中的列名gid（属性名和列名一致自动映射）
			 * 把gid传入到one=@One(select="cn.easytop.lesson03.resultMap.anno.
			 * GradeMapper.queryGrade") 此方法中查询出结果映射到Student中的grade属性 property="grade"
			 */
	})
	
	
	@Select("SELECT recid, bookid, stuid, borrowdate, returndate, borrownum" + " FROM recordlist WHERE recid = #{uuid}")
	public BorrowRecord searchBorrowRecord(String uuid);
}
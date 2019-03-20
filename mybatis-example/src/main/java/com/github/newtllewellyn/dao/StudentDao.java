package com.github.newtllewellyn.dao;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.github.newtllewellyn.user.Student;

public interface StudentDao {
	@Insert("INSERT INTO student(stuid, stuname) VALUES(#{id}, #{name})")
	public void saveStudent(Student student);
	
	//what does id mean???
	@Results({ 
		@Result(id=true, column = "stuid", jdbcType = JdbcType.VARCHAR, property = "id", javaType = String.class),
		@Result(column = "stuname", jdbcType = JdbcType.VARCHAR, property = "name", javaType = String.class)})
//	@ConstructorArgs(value = {
//			@Arg(column = "stuid", id = true, javaType = String.class, 
//					jdbcType = JdbcType.VARCHAR, name = "id"),
//			@Arg(column = "stuname", javaType = String.class, 
//			jdbcType = JdbcType.VARCHAR, name = "name")
//			})
	@Select("SELECT stuid, stuname FROM student WHERE stuid = #{id}")
	public Student searchStudentById(String id);
	
	@Results({ 
		@Result(id=true, column = "stuid", jdbcType = JdbcType.VARCHAR, property = "id", javaType = String.class),
		@Result(column = "stuname", jdbcType = JdbcType.VARCHAR, property = "name", javaType = String.class)})
	@Select("SELECT stuid, stuname FROM student WHERE stuname = #{name}")
	public Student searchStudent(String name);
}

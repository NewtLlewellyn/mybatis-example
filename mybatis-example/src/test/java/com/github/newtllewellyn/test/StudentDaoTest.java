package com.github.newtllewellyn.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.github.newtllewellyn.dao.StudentDao;
import com.github.newtllewellyn.user.Student;
import com.github.newtllewellyn.MyBatisInit;

@Ignore
public class StudentDaoTest {

	@Test
	public void testSave() {
		Student student = new Student("12","asn");
		SqlSession session = MyBatisInit.getSession();
		StudentDao studentDao = session.getMapper(StudentDao.class);
		studentDao.saveStudent(student);
		session.close();
	}

}

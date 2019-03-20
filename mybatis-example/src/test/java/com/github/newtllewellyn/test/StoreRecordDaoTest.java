package com.github.newtllewellyn.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.newtllewellyn.MyBatisInit;
import com.github.newtllewellyn.dao.StudentDao;
import com.github.newtllewellyn.user.Student;

public class StoreRecordDaoTest {
	@Test
	public void testSave() {
		Student student = new Student("12","asn");
		SqlSession session = MyBatisInit.getSession();
		StudentDao studentDao = session.getMapper(StudentDao.class);
		studentDao.saveStudent(student);
		session.close();
	}
}

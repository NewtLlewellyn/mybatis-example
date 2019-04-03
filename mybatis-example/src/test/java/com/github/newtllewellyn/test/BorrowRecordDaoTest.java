package com.github.newtllewellyn.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.github.newtllewellyn.MyBatisInit;
import com.github.newtllewellyn.dao.BorrowRecordDao;
import com.github.newtllewellyn.record.BorrowRecord;

@Ignore
public class BorrowRecordDaoTest {
	@Test
	public void testSave() {
		BorrowRecord rec = new BorrowRecord();
		SqlSession session = MyBatisInit.getSession();
		BorrowRecordDao brDao = session.getMapper(BorrowRecordDao.class);
		brDao.saveBorrowRecord(rec);
		session.close();
	}
}

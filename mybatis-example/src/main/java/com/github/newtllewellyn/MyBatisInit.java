package com.github.newtllewellyn;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.newtllewellyn.dao.StudentDao;

public class MyBatisInit {
	private static SqlSessionFactory sqlSessionFactory;
	public static void init() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSession() {
		if(sqlSessionFactory == null) {
			init();
		}
		return sqlSessionFactory.openSession(true);
	}
	
	public static <T> T getDao(Class<T> daoClass) {
		SqlSession session = MyBatisInit.getSession();
		T dao = session.getMapper(daoClass);
		return dao;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

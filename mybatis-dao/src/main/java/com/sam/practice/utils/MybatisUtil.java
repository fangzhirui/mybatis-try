package com.sam.practice.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static synchronized SqlSessionFactory getFactory(){
		if(sqlSessionFactory == null){
			InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream("configuration.xml");
			sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(is);
		}
		return sqlSessionFactory;
	}
	
}

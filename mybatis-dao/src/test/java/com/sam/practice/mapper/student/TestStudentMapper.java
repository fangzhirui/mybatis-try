package com.sam.practice.mapper.student;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sam.practice.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations={
		"classpath:spring-servlet.xml", 
		"classpath:mybatis/spring-mybatis.xml"
		})
public class TestStudentMapper {
	
	public static void main(String args[]){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:mybatis/spring-mybatis.xml");
		System.out.println(ctx);
	}
	
	private SqlSessionFactory factory;
	
	@Resource(name="sqlSessionFactory")
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Test
	public void testGetStudentCount(){
		SqlSession session = this.factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student s = mapper.getStudentById(4);
		System.out.println(s);
		session.close();
	}
	/*
	@Test
	public void testGetStudentById(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student s = mapper.getStudentById(2);
		System.out.println(s);
		session.close();
	}
	
	@Test
	public void testGetStudentByName(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> s = mapper.getStudentByName("%wakaka%");
		System.out.println(s);
		session.close();
	}
	*/
	
	@Test
	public void testInsertStudent(){
		SqlSession session = this.factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setAge(100);
		s.setHeight(100);
		s.setName("susi");
		s.setWeight(200);
		mapper.insertStudent(s);
		session.commit();
		System.out.println(s);
		session.close();
	}
	
	/*
	@Test
	public void testDeleteStudent(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.deleteStudent(2);
		session.commit();
		session.close();
	}
	*/
}

package com.sam.practice.mabatisMapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.sam.practice.mapper.student.StudentMapper;
import com.sam.practice.model.Student;
import com.sam.practice.model.StudentQueryVo;
import com.sam.practice.utils.MybatisUtil;

public class TestMapper {
	
	@Test
	public void TestGetStudentList(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		StudentQueryVo vo = new StudentQueryVo();
		Student s = new Student();
		s.setId(10);
		s.setAge(1000);
		vo.setStudent(s);
		System.out.println(mapper.getStudentList(vo));
		session.close();
	}
	
	@Test
	public void TestGetStudentCount(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		StudentQueryVo vo = new StudentQueryVo();
		Student s = new Student();
		s.setId(10);
		s.setAge(1000);
		vo.setStudent(s);
		System.out.println(mapper.getStudentCount(vo));
		session.close();
	}
	
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
	
	@Test
	public void testInsertStudent(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student s = new Student();
		s.setAge(100);
		s.setHeight(100);
		s.setName("susi");
		s.setWeight(200);
		mapper.insertStudent(s);
		//pls pay attension to commit
		session.commit();
		System.out.println(s);
		session.close();
	}
	
	@Test
	public void testDeleteStudent(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.deleteStudent(2);
		session.commit();
		session.close();
	}
	
}

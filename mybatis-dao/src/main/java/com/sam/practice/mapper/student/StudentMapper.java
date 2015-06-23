package com.sam.practice.mapper.student;

import java.util.List;

import com.sam.practice.model.Student;
import com.sam.practice.model.StudentQueryVo;

public interface StudentMapper {
	
	public List<Student> getStudentList(StudentQueryVo vo);

	public int getStudentCount(StudentQueryVo vo);
	
	public Student getStudentById(int id);
	
	public List<Student> getStudentByName(String key);
	
	public void insertStudent(Student s);
	
	public void deleteStudent(int id);
	
}

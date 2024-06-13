package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Student;

public interface StudentDao {

	public int insert(Student stud);
	
	public int change(Student stud);
	
	public int delete(int studId);
	
	public Student getStudent(int studId);
	
	public List<Student> getAllStudent();
}

package com.spring.jdbc.dao;

import com.spring.jdbc.model.Student;

public interface StudentDao {

	public int insert(Student stud);
	public int change(Student stud);
}

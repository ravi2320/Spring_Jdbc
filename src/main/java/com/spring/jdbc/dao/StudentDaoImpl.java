package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.model.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student stud) {
		String query = "insert into student values(?, ?, ?)";
		int r = this.jdbcTemplate.update(query, stud.getId(), stud.getName(), stud.getCity());
		return r;
	}

	public int change(Student stud) {
		// updating records
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query, stud.getName(), stud.getCity(), stud.getId());
		return r;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

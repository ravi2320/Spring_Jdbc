package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mysql.cj.result.Row;
import com.mysql.cj.result.ValueFactory;
import com.spring.jdbc.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
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

	public int delete(int studId) {
		// Deleting record
		String query = "delete from student where id = ?";
		int r = this.jdbcTemplate.update(query, studId);
		return r;
	}

	public Student getStudent(int studId) {
		// select single object
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studId);
		return student;
	}

	public List<Student> getAllStudent() {
		// select all Students
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

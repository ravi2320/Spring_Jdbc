package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started....." );
        
		/*
		 * //spring jdbc => JdbcTemplate ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); JdbcTemplate
		 * template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		 * 
		 * //insert query String query = "insert into student values(?, ?, ?)";
		 * 
		 * //fire query int res = template.update(query, 102, "Rajendra Kadam", "Pune");
		 * System.out.println("Number of record inserted : " + res);
		 */
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student = new Student(103, "Rajesh", "Pune");
        
        int cnt = studentDao.insert(student);
        System.out.println("Record inserted : " + cnt);
    }
}

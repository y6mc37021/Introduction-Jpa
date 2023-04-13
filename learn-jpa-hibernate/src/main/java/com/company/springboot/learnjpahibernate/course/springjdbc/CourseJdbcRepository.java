package com.company.springboot.learnjpahibernate.course.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private	JdbcTemplate jdbcTemplate;
	
	//INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(1001,'AZUR','MICROSOFT');
	private static String INSERT_QUERY =
			"""
			INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(?,?,?);
			""";
	
	private static String DELETE_QUERY =
			"""
			DELETE FROM COURSE WHERE ID=?
				
			""";
	private static String SELECT_QUERY =
			"""
			SELECT * FROM COURSE WHERE ID=?
			""";
	
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById(long id) {
		jdbcTemplate.update(DELETE_QUERY,id);
	}
	
	public Course findById(long id) {
		Course course = jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
		return course;
		
	}

}

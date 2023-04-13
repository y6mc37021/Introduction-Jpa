package com.company.springboot.learnjpahibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.springboot.learnjpahibernate.course.springjdbc.Course;
import com.company.springboot.learnjpahibernate.course.springjdbc.CourseJdbcRepository;

@Component
public class JdbcCommandLinerRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcRepository jdbcRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		jdbcRepository.insert(new Course(1,"AZUR","MICROSOFT"));
		jdbcRepository.insert(new Course(2,"GCP","GOOGLE"));
		jdbcRepository.insert(new Course(3,"AWS","AMAZON"));
		
		jdbcRepository.deleteById(1l);
		
		System.out.println(jdbcRepository.findById(3));
	}
	
	

}
